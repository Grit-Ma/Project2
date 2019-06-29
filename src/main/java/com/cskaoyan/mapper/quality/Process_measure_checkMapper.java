package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.Process_measure_check;
import com.cskaoyan.bean.quality.Process_measure_checkExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface Process_measure_checkMapper {

    List<Process_measure_check> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Process_measure_check> fuzzyQueryByPMeasureCheckId(@Param("limit") int limit, @Param("offset") int offset,@Param("pid")String pid);

    long countByExample(Process_measure_checkExample example);

    int deleteByExample(Process_measure_checkExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(Process_measure_check record);

    int insertSelective(Process_measure_check record);

    List<Process_measure_check> selectByExample(Process_measure_checkExample example);

    Process_measure_check selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") Process_measure_check record, @Param("example") Process_measure_checkExample example);

    int updateByExample(@Param("record") Process_measure_check record, @Param("example") Process_measure_checkExample example);

    int updateByPrimaryKeySelective(Process_measure_check record);

    int updateByPrimaryKey(Process_measure_check record);
}