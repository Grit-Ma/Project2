package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.FinalMeasuretCheck;
import com.cskaoyan.bean.quality.FinalMeasuretCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinalMeasuretCheckMapper {

    List<FinalMeasuretCheck> selectByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<FinalMeasuretCheck> fuzzyQueryByPid(@Param("limit") int limit, @Param("offset") int offset, @Param("pid")String pid);

    List<FinalMeasuretCheck> fuzzyQueryByOid(@Param("limit") int limit, @Param("offset") int offset, @Param("oid")String oid);

    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);
}