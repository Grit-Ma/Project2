package com.cskaoyan.mapper;

import com.cskaoyan.bean.C_order;
import com.cskaoyan.bean.C_orderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface C_orderMapper {
    long countByExample(C_orderExample example);

    int deleteByExample(C_orderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(C_order record);

    int insertSelective(C_order record);

    List<C_order> selectByExample(C_orderExample example);

    C_order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") C_order record, @Param("example") C_orderExample example);

    int updateByExample(@Param("record") C_order record, @Param("example") C_orderExample example);

    int updateByPrimaryKeySelective(C_order record);

    int updateByPrimaryKey(C_order record);
}