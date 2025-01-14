package com.itsthatjun.ecommerce.mbg.mapper;

import com.itsthatjun.ecommerce.mbg.model.ReturnLog;
import com.itsthatjun.ecommerce.mbg.model.ReturnLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnLogMapper {
    long countByExample(ReturnLogExample example);

    int deleteByExample(ReturnLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnLog row);

    int insertSelective(ReturnLog row);

    List<ReturnLog> selectByExample(ReturnLogExample example);

    ReturnLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") ReturnLog row, @Param("example") ReturnLogExample example);

    int updateByExample(@Param("row") ReturnLog row, @Param("example") ReturnLogExample example);

    int updateByPrimaryKeySelective(ReturnLog row);

    int updateByPrimaryKey(ReturnLog row);
}