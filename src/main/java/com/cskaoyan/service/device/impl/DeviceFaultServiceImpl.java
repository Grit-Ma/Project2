package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.Device_check;
import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.mapper.Device_faultMapper;
import com.cskaoyan.service.device.DeviceFaultService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    Device_faultMapper device_faultMapper;

    @Override
    public PageVo getPage(int page, int rows, List<Device_fault> device_faults){
        PageVo pages = PageTool.getPageVo(device_faults, page, rows);
        return pages;
    }

    @Override
    public List<Device_fault> selectAllFault(){
        List<Device_fault> device_faults = device_faultMapper.selectAllFault();
        return device_faults;
    }
}
