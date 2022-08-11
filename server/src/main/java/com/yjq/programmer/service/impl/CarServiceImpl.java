package com.yjq.programmer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.CarMapper;
import com.yjq.programmer.dao.CommentMapper;
import com.yjq.programmer.dao.UserMapper;
import com.yjq.programmer.domain.Car;
import com.yjq.programmer.domain.CarExample;
import com.yjq.programmer.domain.CommentExample;
import com.yjq.programmer.domain.User;
import com.yjq.programmer.dto.CarDTO;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.dto.UserDTO;
import com.yjq.programmer.enums.RoleEnum;
import com.yjq.programmer.service.ICarService;
import com.yjq.programmer.service.IUserService;
import com.yjq.programmer.util.CommonUtil;
import com.yjq.programmer.util.CopyUtil;
import com.yjq.programmer.util.UuidUtil;
import com.yjq.programmer.util.ValidateEntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-13 8:27
 */
@Service
@Transactional
public class CarServiceImpl implements ICarService {

    @Resource
    private CarMapper carMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private IUserService userService;

    /**
     * 分页获取汽车数据
     * @param pageDTO
     * @return
     */
    @Override
    public ResponseDTO<PageDTO<CarDTO>> getCarList(PageDTO<CarDTO> pageDTO) {
        CarExample carExample = new CarExample();
        // 不知道当前页多少，默认为第一页
        if(pageDTO.getPage() == null){
            pageDTO.setPage(1);
        }
        // 不知道每页多少条记录，默认为每页5条记录
        if(pageDTO.getSize() == null){
            pageDTO.setSize(5);
        }
        CarExample.Criteria c1 = carExample.createCriteria();
        if(pageDTO.getParam() != null) {
            CarDTO carDTO = pageDTO.getParam();
            if(carDTO.getState() != null && carDTO.getState() != 0) {
                c1.andNameLike("%" + carDTO.getName() + "%").andStateEqualTo(carDTO.getState());
            } else {
                c1.andNameLike("%" + carDTO.getName() + "%");
            }
            ResponseDTO<UserDTO> loginUser = userService.getLoginUser(carDTO.getToken());
            if(loginUser.getCode() != 0) {
                pageDTO.setTotal(0l);
                pageDTO.setList(new ArrayList<>());
                return ResponseDTO.success(pageDTO);
            }
            UserDTO loginUserDTO = loginUser.getData();
            if(RoleEnum.SELLER.getCode().equals(loginUserDTO.getRoleId())) {
                // 如果是销售  只能查看自己发布的汽车信息
                c1.andUserIdEqualTo(loginUserDTO.getId());
            }
        }
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        // 分页查出汽车数据
        List<Car> carList = carMapper.selectByExample(carExample);
        PageInfo<Car> pageInfo = new PageInfo<>(carList);
        // 获取数据的总数
        pageDTO.setTotal(pageInfo.getTotal());
        // 讲domain类型数据  转成 DTO类型数据
        List<CarDTO> carDTOList = CopyUtil.copyList(carList, CarDTO.class);
        for(CarDTO carDTO : carDTOList) {
            User user = userMapper.selectByPrimaryKey(carDTO.getUserId());
            carDTO.setUserDTO(CopyUtil.copy(user, UserDTO.class));
        }
        pageDTO.setList(carDTOList);
        return ResponseDTO.success(pageDTO);
    }

    /**
     * 保存汽车信息
     * @param carDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> saveCar(CarDTO carDTO) {
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(carDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        Car car = CopyUtil.copy(carDTO, Car.class);
        if(CommonUtil.isEmpty(car.getId())) {
            // 添加操作
            car.setId(UuidUtil.getShortUuid());
            if(carMapper.insertSelective(car) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.CAR_ADD_ERROR);
            }
        } else {
            // 修改操作
            if(carMapper.updateByPrimaryKeySelective(car) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.CAR_EDIT_ERROR);
            }
        }
        return ResponseDTO.successByMsg(true, "保存汽车信息成功！");
    }

    /**
     * 删除汽车信息
     * @param carDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> deleteCar(CarDTO carDTO) {
        if(CommonUtil.isEmpty(carDTO.getId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        String[] ids = carDTO.getId().split(",");
        for(String id : ids) {
            // 删除汽车信息
            if(carMapper.deleteByPrimaryKey(id) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.CAR_DELETE_ERROR);
            }
            // 删除汽车评论信息
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria().andCarIdEqualTo(id);
            commentMapper.deleteByExample(commentExample);
        }
        return ResponseDTO.successByMsg(true, "删除汽车信息成功！");
    }

    /**
     * 统计汽车总数
     * @return
     */
    @Override
    public ResponseDTO<Integer> totalCar() {
        return ResponseDTO.success(carMapper.countByExample(new CarExample()));
    }
}
