package com.yjq.programmer.controller;

import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.RentalDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.IRentalService;
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
 * @create 2022-06-15 8:56
 */
@RestController
@RequestMapping("/rental")
public class RentalController {

    @Resource
    private IRentalService rentalService;

    /**
     * 保存租赁信息
     * @param rentalDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseDTO<Boolean> saveRental(@RequestBody RentalDTO rentalDTO){
        return rentalService.saveRental(rentalDTO);
    }

    /**
     * 审核租赁信息
     * @param rentalDTO
     * @return
     */
    @PostMapping("/reply")
    public ResponseDTO<Boolean> replyRental(@RequestBody RentalDTO rentalDTO){
        return rentalService.replyRental(rentalDTO);
    }

    /**
     * 分页获取租赁数据
     * @param pageDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<PageDTO<RentalDTO>> getRentalList(@RequestBody PageDTO<RentalDTO> pageDTO){
        return rentalService.getRentalList(pageDTO);
    }


    /**
     * 删除租赁信息
     * @param rentalDTO
     * @return
     */
    @PostMapping("/delete")
    public ResponseDTO<Boolean> deleteRental(@RequestBody RentalDTO rentalDTO){
        return rentalService.deleteRental(rentalDTO);
    }

    /**
     * 统计租赁总数
     * @return
     */
    @PostMapping("/total")
    public ResponseDTO<Integer> totalRental(){
        return rentalService.totalRental();
    }

    /**
     * 根据时间范围和租赁状态获取交易完成的租赁总数
     * @return
     */
    @PostMapping("/total-day")
    public ResponseDTO<List<Integer>> getRentalTotalByDateAndState(){
        return rentalService.getRentalTotalByDateAndState();
    }
}
