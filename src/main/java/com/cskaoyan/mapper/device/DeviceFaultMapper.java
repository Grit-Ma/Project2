package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.bean.device.DeviceFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceFaultMapper {
    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault>selectAllFault();

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    List<DeviceFault>selectByName(String searchValue);

    List<DeviceFault>selectByFaultId(String searchValue);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);
}