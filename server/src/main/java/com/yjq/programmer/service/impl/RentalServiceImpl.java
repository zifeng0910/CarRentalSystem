package com.yjq.programmer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.CarMapper;
import com.yjq.programmer.dao.RentalItemMapper;
import com.yjq.programmer.dao.RentalMapper;
import com.yjq.programmer.dao.UserMapper;
import com.yjq.programmer.dao.my.MyRentalMapper;
import com.yjq.programmer.domain.*;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.RentalDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.dto.UserDTO;
import com.yjq.programmer.enums.CarStateEnum;
import com.yjq.programmer.enums.RentalStateEnum;
import com.yjq.programmer.enums.RoleEnum;
import com.yjq.programmer.service.IRentalService;
import com.yjq.programmer.service.IUserService;
import com.yjq.programmer.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-15 8:56
 */
@Service
@Transactional
public class RentalServiceImpl implements IRentalService {

    @Resource
    private RentalMapper rentalMapper;

    @Resource
    private CarMapper carMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RentalItemMapper rentalItemMapper;

    @Resource
    private MyRentalMapper myRentalMapper;

    @Resource
    private IUserService userService;

    /**
     * 保存租赁信息
     * @param rentalDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> saveRental(RentalDTO rentalDTO) {
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(rentalDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        // 判断租赁的天数
        int days = (int) ((rentalDTO.getEndTime().getTime() - rentalDTO.getStartTime().getTime()) / (1000*3600*24));
        if(days == 0) {
            rentalDTO.setRentalDay(1);
        } else {
            if((rentalDTO.getEndTime().getTime() - rentalDTO.getStartTime().getTime()) % (1000*3600*24) > 0) {
                rentalDTO.setRentalDay(days + 1);
            } else {
                rentalDTO.setRentalDay(days);
            }
        }
        if(rentalDTO.getStartTime().getTime() < (new Date()).getTime()) {
            return ResponseDTO.errorByMsg(CodeMsg.START_TIME_ILLEGAL);
        }
        // 判断车子状态
        Car car = carMapper.selectByPrimaryKey(rentalDTO.getCarId());
        if(car == null) {
            return ResponseDTO.errorByMsg(CodeMsg.CAR_NOT_EXIST);
        }
        if(CarStateEnum.ALREADY.getCode().equals(car.getState())) {
            return ResponseDTO.errorByMsg(CodeMsg.CAR_ALREADY_RENTAL);
        }
        // 计算租赁总价  租赁天数*每日租金+汽车押金
        rentalDTO.setTotalPrice((new BigDecimal(rentalDTO.getRentalDay()).multiply(rentalDTO.getDayPrice())).add(rentalDTO.getPledgePrice()));
        Rental rental = CopyUtil.copy(rentalDTO, Rental.class);
        rental.setState(RentalStateEnum.WAIT.getCode());
        rental.setSellerId(car.getUserId());
        if(CommonUtil.isEmpty(rentalDTO.getId())) {
            // 添加操作
            rental.setId(UuidUtil.getShortUuid());
            rental.setNo(String.valueOf(new SnowFlake(2,3).nextId()));
            rental.setCreateTime(new Date());
            if(rentalMapper.insertSelective(rental) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.RENTAL_ADD_ERROR);
            }
        } else {
            // 修改操作
            if(rentalMapper.updateByPrimaryKeySelective(rental) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.RENTAL_EDIT_ERROR);
            }
        }
        // 修改车子状态
        car.setState(CarStateEnum.ALREADY.getCode());
        carMapper.updateByPrimaryKeySelective(car);
        return ResponseDTO.successByMsg(true, "保存租赁信息成功！");
    }

    /**
     * 分页获取租赁数据
     * @param pageDTO
     * @return
     */
    @Override
    public ResponseDTO<PageDTO<RentalDTO>> getRentalList(PageDTO<RentalDTO> pageDTO) {
        RentalExample rentalExample = new RentalExample();
        // 不知道当前页多少，默认为第一页
        if(pageDTO.getPage() == null){
            pageDTO.setPage(1);
        }
        // 不知道每页多少条记录，默认为每页5条记录
        if(pageDTO.getSize() == null){
            pageDTO.setSize(5);
        }
        RentalExample.Criteria c1 = rentalExample.createCriteria();
        if(pageDTO.getParam() != null) {
            RentalDTO rentalDTO = pageDTO.getParam();
            if(rentalDTO.getState() != null && rentalDTO.getState() != 0) {
                c1.andNoLike("%" + rentalDTO.getNo() + "%").andStateEqualTo(rentalDTO.getState());
            } else {
                c1.andNoLike("%" + rentalDTO.getNo() + "%");
            }
            ResponseDTO<UserDTO> loginUser = userService.getLoginUser(rentalDTO.getToken());
            if(loginUser.getCode() != 0) {
                pageDTO.setTotal(0l);
                pageDTO.setList(new ArrayList<>());
                return ResponseDTO.success(pageDTO);
            }
            UserDTO loginUserDTO = loginUser.getData();
            if(RoleEnum.CUSTOMER.getCode().equals(loginUserDTO.getRoleId())) {
                // 如果是客户  只能查看自己个人租赁数据
                c1.andUserIdEqualTo(loginUserDTO.getId());
            }
            if(RoleEnum.SELLER.getCode().equals(loginUserDTO.getRoleId())) {
                // 如果是销售  只能查看自己个人租赁数据
                c1.andSellerIdEqualTo(loginUserDTO.getId());
            }
        }
        rentalExample.setOrderByClause("create_time desc");
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        // 分页查出租赁数据
        List<Rental> rentalList = rentalMapper.selectByExample(rentalExample);
        PageInfo<Rental> pageInfo = new PageInfo<>(rentalList);
        // 获取数据的总数
        pageDTO.setTotal(pageInfo.getTotal());
        // 讲domain类型数据  转成 DTO类型数据
        List<RentalDTO> rentalDTOList = CopyUtil.copyList(rentalList, RentalDTO.class);
        for(RentalDTO rentalDTO : rentalDTOList) {
            User user = userMapper.selectByPrimaryKey(rentalDTO.getUserId());
            rentalDTO.setUserDTO(CopyUtil.copy(user, UserDTO.class));
            User seller = userMapper.selectByPrimaryKey(rentalDTO.getSellerId());
            rentalDTO.setSellerDTO(CopyUtil.copy(seller, UserDTO.class));
        }
        pageDTO.setList(rentalDTOList);
        return ResponseDTO.success(pageDTO);
    }

    /**
     * 审核租赁信息
     * @param rentalDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> replyRental(RentalDTO rentalDTO) {
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(rentalDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        Rental rental = CopyUtil.copy(rentalDTO, Rental.class);
        Car car = carMapper.selectByPrimaryKey(rental.getCarId());
        if(car == null) {
            return ResponseDTO.errorByMsg(CodeMsg.CAR_NOT_EXIST);
        }
        // 修改租赁汽车状态
        if(rental.getState().equals(RentalStateEnum.FINISH.getCode()) ||
                rental.getState().equals(RentalStateEnum.FAIL.getCode()) ||
                rental.getState().equals(RentalStateEnum.CANCEL.getCode())) {
            car.setState(CarStateEnum.WAIT.getCode());
        } else {
            car.setState(CarStateEnum.ALREADY.getCode());
        }
        carMapper.updateByPrimaryKeySelective(car);
        if(rentalMapper.updateByPrimaryKeySelective(rental) == 0) {
            return ResponseDTO.errorByMsg(CodeMsg.REPLY_ERROR);
        }
        return ResponseDTO.successByMsg(true, "审核成功！");
    }

    /**
     * 删除租赁信息
     * @param rentalDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> deleteRental(RentalDTO rentalDTO) {
        if(CommonUtil.isEmpty(rentalDTO.getId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        String[] ids = rentalDTO.getId().split(",");
        for(String id : ids) {
            Rental rental = rentalMapper.selectByPrimaryKey(id);
            // 删除租赁信息
            if(rentalMapper.deleteByPrimaryKey(id) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.RENTAL_DELETE_ERROR);
            }
            // 修改租赁汽车状态
            if(rental.getState().equals(RentalStateEnum.RENTAL.getCode()) ||
                rental.getState().equals(RentalStateEnum.WAIT.getCode()) ||
                rental.getState().equals(RentalStateEnum.SUCCESS.getCode())) {
                Car car = carMapper.selectByPrimaryKey(rental.getCarId());
                if(car == null) {
                    continue;
                }
                car.setState(CarStateEnum.WAIT.getCode());
                carMapper.updateByPrimaryKeySelective(car);
            }
            // 删除租赁详情信息
            RentalItemExample rentalItemExample = new RentalItemExample();
            rentalItemExample.createCriteria().andRentalIdEqualTo(id);
            rentalItemMapper.deleteByExample(rentalItemExample);
        }
        return ResponseDTO.successByMsg(true, "删除汽车信息成功！");
    }

    /**
     * 统计租赁总数
     * @return
     */
    @Override
    public ResponseDTO<Integer> totalRental() {
        return ResponseDTO.success(rentalMapper.countByExample(new RentalExample()));
    }

    /**
     * 根据时间范围和租赁状态获取交易完成的租赁总数
     * @return
     */
    @Override
    public ResponseDTO<List<Integer>> getRentalTotalByDateAndState() {
        List<Integer> totalList = new ArrayList<>();
        Map<String, Object> queryMap = new HashMap<>();
        List<Integer> stateList = new ArrayList<>();
        stateList.add(1);
        stateList.add(2);
        stateList.add(3);
        // 获取前天已完成的收益次数
        queryMap.put("start", 2);
        queryMap.put("end", 1);
        totalList.add(myRentalMapper.getRentalTotalByDateAndState(queryMap, stateList));
        // 获取昨天已完成的收益次数
        queryMap.put("start", 1);
        queryMap.put("end", 0);
        totalList.add(myRentalMapper.getRentalTotalByDateAndState(queryMap, stateList));
        // 获取当天已完成的收益次数
        queryMap.put("start", 0);
        queryMap.put("end", -1);
        totalList.add(myRentalMapper.getRentalTotalByDateAndState(queryMap, stateList));
        return ResponseDTO.success(totalList);
    }


}
