package com.yjq.programmer.service;

import com.yjq.programmer.dto.CarDTO;
import com.yjq.programmer.dto.PageDTO;
import com.yjq.programmer.dto.ResponseDTO;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-13 8:27
 */
public interface ICarService {

    // 分页获取汽车数据
    ResponseDTO<PageDTO<CarDTO>> getCarList(PageDTO<CarDTO> pageDTO);

    // 保存汽车信息
    ResponseDTO<Boolean> saveCar(CarDTO carDTO);

    // 删除汽车信息
    ResponseDTO<Boolean> deleteCar(CarDTO carDTO);

    // 统计汽车总数
    ResponseDTO<Integer> totalCar();
}
