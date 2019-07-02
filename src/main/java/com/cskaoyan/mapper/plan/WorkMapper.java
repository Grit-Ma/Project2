package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.plan.Work;
import com.cskaoyan.bean.plan.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> getWorkByWorkId(String searchValue);

    List<Work> selectForWorkAndProductAndProcessAndDevice();

    List<Work> getWorkByProduct(String searchValue);

    List<Work> getWorkByDevice(String searchValue);

    List<Work> getWorkByProcess(String searchValue);
}