package com.yjq.programmer.controller;

import com.yjq.programmer.dto.RentalItemDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.IRentalItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-16 8:49
 */
@RestController
@RequestMapping("/rental_item")
public class RentalItemController {

    @Resource
    private IRentalItemService rentalItemService;

    /**
     * 保存租赁详情信息
     * @param rentalItemDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseDTO<Boolean> saveRentalItem(@RequestBody RentalItemDTO rentalItemDTO){
        return rentalItemService.saveRentalItem(rentalItemDTO);
    }

    /**
     * 删除租赁详情信息
     * @param rentalItemDTO
     * @return
     */
    @PostMapping("/delete")
    public ResponseDTO<Boolean> deleteRentalItem(@RequestBody RentalItemDTO rentalItemDTO){
        return rentalItemService.deleteRentalItem(rentalItemDTO);
    }

    /**
     * 获取租赁详情数据
     * @param rentalItemDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<List<RentalItemDTO>> getRentalItemList(@RequestBody RentalItemDTO rentalItemDTO){
        return rentalItemService.getRentalItemList(rentalItemDTO);
    }
}
