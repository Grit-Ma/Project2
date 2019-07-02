package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.Device;
import com.cskaoyan.bean.device.DeviceExample;
import java.util.List;

import com.cskaoyan.bean.device.DevicePlus;

import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    List<Device> selectAllDevice();

    Device selectByPrimaryKey(String deviceId);

    List<DevicePlus> selectById(String searchValue);

    List<DevicePlus> selectByName(String searchValue);

    List<DevicePlus> selectByTypeName(String searchValue);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}