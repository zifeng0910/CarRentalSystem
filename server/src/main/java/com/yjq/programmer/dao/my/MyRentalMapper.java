package com.yjq.programmer.dao.my;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-18 22:48
 */
public interface MyRentalMapper {

    // 根据时间范围和租赁状态获取交易完成的租赁总数
    Integer getRentalTotalByDateAndState(@Param("queryMap") Map<String, Object> queryMap, @Param("stateList") List<Integer> stateList);
}
