package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/26
 */

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> selectAllDevice() {
        List<Device> devices = deviceMapper.selectAllDevice();
        return devices;
    }
}
