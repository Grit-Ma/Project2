package com.cskaoyan.service.quality;

import com.cskaoyan.bean.quality.ProcessMeasureCheck;
import com.cskaoyan.bean.quality.ProcessMeasureCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckService {

    List<ProcessMeasureCheck> selectByPage(int page, int rows);

    List<ProcessMeasureCheck> fuzzyQueryByPMeasureCheckId(int page, int rows, String pid);

    long countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
}
