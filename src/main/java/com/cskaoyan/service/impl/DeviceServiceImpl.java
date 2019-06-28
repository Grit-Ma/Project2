package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
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

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Device> selectAllDevice() {
        List<Device> devices = deviceMapper.selectAllDevice();
        return devices;
    }


    @Override
    public List<Department> selectAllDepartment() {
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        return departments;
    }

    @Override
    public Department selectDepartmentById(String departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public PageVo getPage(int page, int rows, List<DevicePlus> devicePluses) {
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public ResponseVo insertDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceMapper.insert(devicePlus);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
