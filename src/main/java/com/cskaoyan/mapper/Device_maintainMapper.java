package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.bean.Device_maintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Device_maintainMapper {
    long countByExample(Device_maintainExample example);

    int deleteByExample(Device_maintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_maintain record);

    int insertSelective(Device_maintain record);

    List<Device_maintain> selectByExample(Device_maintainExample example);

    Device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") Device_maintain record, @Param("example") Device_maintainExample example);

    int updateByExample(@Param("record") Device_maintain record, @Param("example") Device_maintainExample example);

    int updateByPrimaryKeySelective(Device_maintain record);

    int updateByPrimaryKey(Device_maintain record);
}