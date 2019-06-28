package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceKeeper;
import com.cskaoyan.bean.DevicePlus;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/26
 */
public interface DeviceService {

    List<Device> selectAllDevice();

    List<Department> selectAllDepartment();

    Department selectDepartmentById(String departmentId);

    PageVo getPage(int page, int rows, List<DevicePlus> devicePluses);

    ResponseVo insertDevice(DevicePlus devicePlus);
}
