package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.ProcessMeasureCheck;
import com.cskaoyan.bean.quality.ProcessMeasureCheckExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ProcessMeasureCheckMapper {

    List<ProcessMeasureCheck> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<ProcessMeasureCheck> fuzzyQueryByPMeasureCheckId(@Param("limit") int limit, @Param("offset") int offset, @Param("pid")String pid);

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
