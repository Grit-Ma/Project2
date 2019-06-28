package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device_type;
import com.cskaoyan.bean.Device_typeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Device_typeMapper {
    long countByExample(Device_typeExample example);

    int deleteByExample(Device_typeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(Device_type record);

    int insertSelective(Device_type record);

    List<Device_type> selectByExample(Device_typeExample example);

    List<Device_type> selectAllType();

    Device_type selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") Device_type record, @Param("example") Device_typeExample example);

    int updateByExample(@Param("record") Device_type record, @Param("example") Device_typeExample example);

    int updateByPrimaryKeySelective(Device_type record);

    int updateByPrimaryKey(Device_type record);
}