package com.yjq.programmer.service;

import com.yjq.programmer.dto.RentalItemDTO;
import com.yjq.programmer.dto.ResponseDTO;

import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-16 8:50
 */
public interface IRentalItemService {

    // 保存租赁详情信息
    ResponseDTO<Boolean> saveRentalItem(RentalItemDTO rentalItemDTO);

    // 获取租赁详情数据
    ResponseDTO<List<RentalItemDTO>> getRentalItemList(RentalItemDTO rentalItemDTO);

    // 删除租赁详情数据
    ResponseDTO<Boolean> deleteRentalItem(RentalItemDTO rentalItemDTO);
}
