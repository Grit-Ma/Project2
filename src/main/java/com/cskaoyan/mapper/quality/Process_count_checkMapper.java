package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.Process_count_check;
import com.cskaoyan.bean.quality.Process_count_checkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Process_count_checkMapper {

    List<Process_count_check> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Process_count_check> fuzzyQueryByPCountCheckId(@Param("limit") int limit, @Param("offset") int offset,@Param("cid") String cid);

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