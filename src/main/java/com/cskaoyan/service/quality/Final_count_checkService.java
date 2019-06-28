package com.cskaoyan.service.quality;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Final_count_checkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Final_count_checkService {

    List<Final_count_check> selectByPage(int page,int rows);

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
