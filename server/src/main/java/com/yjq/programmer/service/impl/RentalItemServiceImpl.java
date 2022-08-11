package com.yjq.programmer.service.impl;

import com.yjq.programmer.bean.CodeMsg;
import com.yjq.programmer.dao.RentalItemMapper;
import com.yjq.programmer.dao.RentalMapper;
import com.yjq.programmer.domain.Rental;
import com.yjq.programmer.domain.RentalItem;
import com.yjq.programmer.domain.RentalItemExample;
import com.yjq.programmer.dto.RentalItemDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.enums.RentalItemTypeEnum;
import com.yjq.programmer.service.IRentalItemService;
import com.yjq.programmer.util.CommonUtil;
import com.yjq.programmer.util.CopyUtil;
import com.yjq.programmer.util.UuidUtil;
import com.yjq.programmer.util.ValidateEntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-16 8:50
 */
@Service
@Transactional
public class RentalItemServiceImpl implements IRentalItemService {

    @Resource
    private RentalItemMapper rentalItemMapper;

    @Resource
    private RentalMapper rentalMapper;

    /**
     * 保存租赁详情信息
     * @param rentalItemDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> saveRentalItem(RentalItemDTO rentalItemDTO) {
        // 进行统一表单验证
        CodeMsg validate = ValidateEntityUtil.validate(rentalItemDTO);
        if (!validate.getCode().equals(CodeMsg.SUCCESS.getCode())) {
            return ResponseDTO.errorByMsg(validate);
        }
        RentalItem rentalItem = CopyUtil.copy(rentalItemDTO, RentalItem.class);
        if(RentalItemTypeEnum.NORMAL.getCode().equals(rentalItem.getType())) {
            rentalItem.setPrice(new BigDecimal("0.00"));
        }
        if(CommonUtil.isEmpty(rentalItem.getId())) {
            // 添加操作
            rentalItem.setId(UuidUtil.getShortUuid());
            rentalItem.setCreateTime(new Date());
            if(rentalItemMapper.insertSelective(rentalItem) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.RENTAL_ITEM_ADD_ERROR);
            }
        } else {
            // 修改操作
            if(rentalItemMapper.updateByPrimaryKeySelective(rentalItem) == 0) {
                return ResponseDTO.errorByMsg(CodeMsg.RENTAL_ITEM_EDIT_ERROR);
            }
        }
        computeTotalPrice(rentalItem.getRentalId());
        return ResponseDTO.successByMsg(true, "保存租赁记录信息成功！");
    }

    /**
     * 计算租赁总费用
     * @param id
     */
    public void computeTotalPrice(String id) {
        Rental rental = rentalMapper.selectByPrimaryKey(id);
        RentalItemExample rentalItemExample = new RentalItemExample();
        rentalItemExample.createCriteria().andRentalIdEqualTo(rental.getId()).andTypeEqualTo(RentalItemTypeEnum.ILLEGAL.getCode());
        List<RentalItem> rentalItemList = rentalItemMapper.selectByExample(rentalItemExample);
        BigDecimal totalPrice = new BigDecimal("0.00");
        totalPrice = (new BigDecimal(rental.getRentalDay()).multiply(rental.getDayPrice())).add(rental.getPledgePrice());
        for(RentalItem rentalItem : rentalItemList) {
            totalPrice = totalPrice.add(rentalItem.getPrice());
        }
        rental.setTotalPrice(totalPrice);
        rentalMapper.updateByPrimaryKeySelective(rental);
    }

    /**
     * 获取租赁详情数据
     * @param rentalItemDTO
     * @return
     */
    @Override
    public ResponseDTO<List<RentalItemDTO>> getRentalItemList(RentalItemDTO rentalItemDTO) {
        if(CommonUtil.isEmpty(rentalItemDTO.getRentalId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        RentalItemExample rentalItemExample = new RentalItemExample();
        rentalItemExample.setOrderByClause("create_time desc");
        rentalItemExample.createCriteria().andRentalIdEqualTo(rentalItemDTO.getRentalId());
        List<RentalItem> rentalItemList = rentalItemMapper.selectByExample(rentalItemExample);
        return ResponseDTO.success(CopyUtil.copyList(rentalItemList, RentalItemDTO.class));
    }

    /**
     * 删除租赁详情数据
     * @param rentalItemDTO
     * @return
     */
    @Override
    public ResponseDTO<Boolean> deleteRentalItem(RentalItemDTO rentalItemDTO) {
        if(CommonUtil.isEmpty(rentalItemDTO.getId())) {
            return ResponseDTO.errorByMsg(CodeMsg.DATA_ERROR);
        }
        RentalItem rentalItem = rentalItemMapper.selectByPrimaryKey(rentalItemDTO.getId());
        if(rentalItemMapper.deleteByPrimaryKey(rentalItemDTO.getId()) == 0) {
            return ResponseDTO.errorByMsg(CodeMsg.RENTAL_ITEM_DELETE_ERROR);
        }
        computeTotalPrice(rentalItem.getRentalId());
        return ResponseDTO.successByMsg(true, "删除租赁详情数据成功！");
    }
}
