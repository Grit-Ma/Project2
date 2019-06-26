package com.cskaoyan.mapper;

import com.cskaoyan.bean.Final_measuret_check;
import com.cskaoyan.bean.Final_measuret_checkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Final_measuret_checkMapper {
    long countByExample(Final_measuret_checkExample example);

    int deleteByExample(Final_measuret_checkExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(Final_measuret_check record);

    int insertSelective(Final_measuret_check record);

    List<Final_measuret_check> selectByExample(Final_measuret_checkExample example);

    Final_measuret_check selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") Final_measuret_check record, @Param("example") Final_measuret_checkExample example);

    int updateByExample(@Param("record") Final_measuret_check record, @Param("example") Final_measuret_checkExample example);

    int updateByPrimaryKeySelective(Final_measuret_check record);

    int updateByPrimaryKey(Final_measuret_check record);
}