package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device_type;
import com.cskaoyan.mapper.Device_typeMapper;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    Device_typeMapper deviceTypeMapper;

    @Override
    public Device_type selectTypeById(String typeId) {
        return deviceTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<Device_type> selectAllType(){
        return deviceTypeMapper.selectAllType();
    }
}
