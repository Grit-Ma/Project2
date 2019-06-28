package com.cskaoyan.mapper;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Final_count_checkExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Final_count_checkMapper {

    List<Final_count_check> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Final_count_check> fuzzyQueryByCountCheckId(@Param("limit") int limit, @Param("offset") int offset,@Param("cid")String cid);

    List<Final_count_check> fuzzyQueryByCountOrderId(@Param("limit") int limit, @Param("offset") int offset,@Param("oid")String oid);

    long countByExample(Final_count_checkExample example);

    int deleteByExample(Final_count_checkExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(Final_count_check record);

    int insertSelective(Final_count_check record);

    List<Final_count_check> selectByExample(Final_count_checkExample example);

    Final_count_check selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") Final_count_check record, @Param("example") Final_count_checkExample example);

    int updateByExample(@Param("record") Final_count_check record, @Param("example") Final_count_checkExample example);

    int updateByPrimaryKeySelective(Final_count_check record);

    int updateByPrimaryKey(Final_count_check record);
}