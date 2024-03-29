package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.FinalCountCheck;
import com.cskaoyan.bean.quality.FinalCountCheckExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FinalCountCheckMapper {

    List<FinalCountCheck> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<FinalCountCheck> fuzzyQueryByCountCheckId(@Param("limit") int limit, @Param("offset") int offset, @Param("cid")String cid);

    List<FinalCountCheck> fuzzyQueryByCountOrderId(@Param("limit") int limit, @Param("offset") int offset, @Param("oid")String oid);

    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}