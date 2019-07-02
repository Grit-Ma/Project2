package com.cskaoyan.service.quality;

import com.cskaoyan.bean.quality.FinalCountCheck;
import com.cskaoyan.bean.quality.FinalCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckService {

    List<FinalCountCheck> selectByPage(int page, int rows);

    List<FinalCountCheck> fuzzyQueryByCountCheckId(int page, int rows, String cid);

    List<FinalCountCheck> fuzzyQueryByCountOrderId(int page, int rows, String oid);

    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}
