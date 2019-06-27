package com.cskaoyan.service;

import com.cskaoyan.bean.Device_type;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */
public interface DeviceTypeService {

    Device_type selectTypeById(String typeId);

    List<Device_type> selectAllType();
}
