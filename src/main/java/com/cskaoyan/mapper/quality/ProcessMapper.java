package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.Process;
import com.cskaoyan.bean.quality.ProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> queyProcessByPageAndRows(@Param("number") int number, @Param("offset") int offset);

    int queryTotalProcess();

    int deleteBatch(@Param("ids") String[] ids);

    List<Process> searchByProcessIdOrName(@Param("search") String search, @Param("number") int number, @Param("offset") int offset, @Param("flag") String flag);

    int searchByProcessTotal(@Param("search") String search, @Param("flag") String flag);
}