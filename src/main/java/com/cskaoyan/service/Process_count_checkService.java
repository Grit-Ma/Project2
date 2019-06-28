package com.cskaoyan.service;

import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.bean.Process_count_checkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Process_count_checkService {

    List<Process_count_check> selectByPage(int page, int rows);

    long countByExample(Process_count_checkExample example);

    int deleteByExample(Process_count_checkExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(Process_count_check record);

    int insertSelective(Process_count_check record);

    List<Process_count_check> selectByExample(Process_count_checkExample example);

    Process_count_check selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") Process_count_check record, @Param("example") Process_count_checkExample example);

    int updateByExample(@Param("record") Process_count_check record, @Param("example") Process_count_checkExample example);

    int updateByPrimaryKeySelective(Process_count_check record);

    int updateByPrimaryKey(Process_count_check record);
}
