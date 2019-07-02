package com.cskaoyan.mapper.device;


import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.bean.device.DeviceMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMaintainMapper {
    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    List<DeviceMaintain> selectAllMaintain();

    List<DeviceMaintain>selectByMaintainId(String searchValue);

    List<DeviceMaintain>selectByFaultId(String searchValue);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);
}