package com.yjq.programmer.controller;

import com.yjq.programmer.dto.CarDTO;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;
import com.yjq.programmer.service.ICarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-13 8:26
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Resource
    private ICarService carService;

    /**
     * 分页获取汽车数据
     * @param pageDTO
     * @return
     */
    @PostMapping("/list")
    public ResponseDTO<PageDTO<CarDTO>> getCarList(@RequestBody PageDTO<CarDTO> pageDTO){
        return carService.getCarList(pageDTO);
    }

    /**
     * 保存汽车信息
     * @param carDTO
     * @return
     */
    @PostMapping("/save")
    public ResponseDTO<Boolean> saveCar(@RequestBody CarDTO carDTO){
        return carService.saveCar(carDTO);
    }

    /**
     * 删除汽车信息
     * @param carDTO
     * @return
     */
    @PostMapping("/delete")
    public ResponseDTO<Boolean> deleteCar(@RequestBody CarDTO carDTO){
        return carService.deleteCar(carDTO);
    }

    /**
     * 统计汽车总数
     * @return
     */
    @PostMapping("/total")
    public ResponseDTO<Integer> totalCar(){
        return carService.totalCar();
    }
}
