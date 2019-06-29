package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.bean.Device_maintainExample;
import com.cskaoyan.mapper.Device_maintainMapper;
import com.cskaoyan.service.device.DeviceMaintainService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    Device_maintainMapper device_maintainMapper;

    @Override
    public PageVo getPage(int page, int rows, List<Device_maintain> device_maintains) {
        PageVo pages = PageTool.getPageVo(device_maintains, page, rows);
        return pages;
    }

    @Override
    public List<Device_maintain> selectAllMaintain() {
        List<Device_maintain> device_maintains= device_maintainMapper.selectByExample(new Device_maintainExample());
        return device_maintains;
    }

    @Override
    public ResponseVo insertMaintain(Device_maintain device_maintain) {
        return null;
    }

    @Override
    public ResponseVo updateMaintain(Device_maintain device_maintain) {
        return null;
    }

    @Override
    public ResponseVo deleteMaintain(List<String> ids) {
        return null;
    }

    @Override
    public PageVo selectByFaultId(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public PageVo selectByMaintianId(String searchValue, int page, int rows) {
        return null;
    }
}
