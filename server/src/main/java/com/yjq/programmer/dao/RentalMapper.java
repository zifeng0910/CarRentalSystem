package com.yjq.programmer.dao;

import com.yjq.programmer.domain.Rental;
import com.yjq.programmer.domain.RentalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentalMapper {
    int countByExample(RentalExample example);

    int deleteByExample(RentalExample example);

    int deleteByPrimaryKey(String id);

    int insert(Rental record);

    int insertSelective(Rental record);

    List<Rental> selectByExample(RentalExample example);

    Rental selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByExample(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);
}
