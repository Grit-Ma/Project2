package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.ProcessCountCheck;
import com.cskaoyan.bean.quality.ProcessCountCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessCountCheckMapper {

    List<ProcessCountCheck> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<ProcessCountCheck> fuzzyQueryByPCountCheckId(@Param("limit") int limit, @Param("offset") int offset, @Param("cid") String cid);

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