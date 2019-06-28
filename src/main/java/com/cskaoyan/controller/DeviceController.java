package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DevicePlus;
import com.cskaoyan.bean.Device_type;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.DeviceKeeperService;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * created by ZengWei
 * on 2019/6/26
 */

@Controller
public class DeviceController {


    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceTypeService deviceTypeService;

    @Autowired
    DeviceKeeperService deviceKeeperService;

    @RequestMapping("device/deviceList")
    public String gotoList() {
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceList/list")
    public List<DevicePlus> selectAllDevice() {
        List<Device> devices = deviceService.selectAllDevice();
        List<DevicePlus> devicePluses = new ArrayList<>();
        for (int i = 0; i < devices.size() ; i++) {
            Device d = devices.get(i);
            devicePluses.add(new DevicePlus());
            DevicePlus dp = devicePluses.get(i);
            dp.setDeviceId(d.getDeviceId());
            dp.setDeviceName(d.getDeviceName());
            dp.setDeviceStatusId(d.getDeviceStatusId());
            dp.setDeviceStatus(d.getDeviceStatus());
            dp.setDevicePurchaseDate(d.getDevicePurchaseDate());
            dp.setDevicePurchasePrice(d.getDevicePurchasePrice());
            dp.setDeviceManufactureDate(d.getDeviceManufactureDate());
            dp.setDeviceServiceLife(d.getDeviceServiceLife());
            dp.setDeviceKeeperId(d.getDeviceKeeperId());
            dp.setDeviceTypeId(d.getDeviceTypeId());
            dp.setNote(d.getNote());
            dp.setDeviceTypeName(deviceTypeService.selectTypeById(d.getDeviceTypeId()).getDeviceTypeName());
            dp.setDeviceKeeper(deviceKeeperService.selectEmpById(d.getDeviceKeeperId()).getEmpName());
        }
        return devicePluses;
    }

    @RequestMapping("device/deviceType")
    public String gotoType() {
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceType/list")
    public List<Device_type> selectAllType() {
        return deviceTypeService.selectAllType();
    }

    @ResponseBody
    @RequestMapping("deviceType/get/{TypeId}")
    public Device_type searchTypeInfo(@PathVariable("TypeId") String TypeId)
    {
        return deviceTypeService.selectTypeById(TypeId);
    }

    @ResponseBody
    @RequestMapping("employee/get/{EmpId}")
    public Employee searchEmpInfo(@PathVariable("EmpId") String EmpId)
    {
        return deviceKeeperService.selectEmpById(EmpId);
    }
}
