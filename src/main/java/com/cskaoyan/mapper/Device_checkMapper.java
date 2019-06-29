package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device_check;
import com.cskaoyan.bean.Device_checkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Device_checkMapper {
    long countByExample(Device_checkExample example);

    int deleteByExample(Device_checkExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_check record);

    int insertSelective(Device_check record);

    List<Device_check> selectByExample(Device_checkExample example);

    List<Device_check> selectAllCheck();

    Device_check selectByPrimaryKey(String deviceCheckId);

    List<Device_check>selectByName(String searchValue);

    List<Device_check>selectByCheckId(String seatchValue);

    int updateByExampleSelective(@Param("record") Device_check record, @Param("example") Device_checkExample example);

    int updateByExample(@Param("record") Device_check record, @Param("example") Device_checkExample example);

    int updateByPrimaryKeySelective(Device_check record);

    int updateByPrimaryKey(Device_check record);
}