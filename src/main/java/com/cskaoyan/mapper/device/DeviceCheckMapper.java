package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.bean.device.DeviceCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {
    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    List<DeviceCheck> selectAllCheck();

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    List<DeviceCheck>selectByName(String searchValue);

    List<DeviceCheck>selectByCheckId(String seatchValue);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
}