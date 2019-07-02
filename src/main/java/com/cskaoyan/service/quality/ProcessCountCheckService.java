package com.cskaoyan.service.quality;

import com.cskaoyan.bean.quality.ProcessCountCheck;
import com.cskaoyan.bean.quality.ProcessCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckService {

    List<ProcessCountCheck> selectByPage(int page, int rows);

    List<ProcessCountCheck> fuzzyQueryByPCountCheckId(int page, int rows, String cid);

    long countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
}
