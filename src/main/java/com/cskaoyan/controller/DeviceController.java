package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceKeeperService;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.service.DeviceTypeService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
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
    public PageVo selectAllDevice(int page, int rows) {
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
        PageVo pageVo = deviceService.getPage(page, rows, devicePluses);
        return pageVo;
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
    public DeviceKeeper searchEmpInfo(@PathVariable("EmpId") String EmpId)
    {
            Employee e = deviceKeeperService.selectEmpById(EmpId);
            DeviceKeeper dk = new DeviceKeeper();
            dk.setEmpId(e.getEmpId());
            dk.setEmpName(e.getEmpName());
            dk.setSex(e.getSex());
            dk.setBirthday(e.getBirthday());
            dk.setDegree(e.getDegree());
            dk.setDepartmentId(e.getDepartmentId());
            dk.setGraduateSchool(e.getGraduateSchool());
            dk.setEducation(e.getEducation());
            dk.setIdCode(e.getIdCode());
            dk.setJoinDate(e.getJoinDate());
            dk.setEducationForm(e.getEducationForm());
            dk.setStatus(e.getStatus());
            dk.setEducationForm(e.getEducationForm());
            dk.setDepartment(deviceService.selectDepartmentById(e.getDepartmentId()));
        return  dk;
    }

    @ResponseBody
    @RequestMapping("department/get_data")
    public List<Department> selectAllDepartment() {
        return deviceService.selectAllDepartment();
    }

    @ResponseBody
    @RequestMapping("deviceList/add_judge")
    public String gotoAddJudge() {
        return null;
    }

    @RequestMapping("deviceList/add")
    public String gotoAdd() {
        return "/WEB-INF/jsp/deviceList_add.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceType/get_data")
    public List<Device_type> selectAllDeviceType() {
        return deviceTypeService.selectAllType();
    }

    @ResponseBody
    @RequestMapping("employee/get_data")
    public List<DeviceKeeper> selectAllDecvieKeeper() {
        List<Employee> employees = deviceKeeperService.selectAllEmp();
        List<DeviceKeeper> deviceKeepers = new ArrayList<>();
        for (int i = 0; i < employees.size() ; i++) {
            Employee e = employees.get(i);
            deviceKeepers.add(new DeviceKeeper());
            DeviceKeeper dk = deviceKeepers.get(i);
            dk.setEmpId(e.getEmpId());
            dk.setEmpName(e.getEmpName());
            dk.setSex(e.getSex());
            dk.setBirthday(e.getBirthday());
            dk.setDegree(e.getDegree());
            dk.setDepartmentId(e.getDepartmentId());
            dk.setGraduateSchool(e.getGraduateSchool());
            dk.setEducation(e.getEducation());
            dk.setIdCode(e.getIdCode());
            dk.setJoinDate(e.getJoinDate());
            dk.setEducationForm(e.getEducationForm());
            dk.setStatus(e.getStatus());
            dk.setEducationForm(e.getEducationForm());
            dk.setDepartment(deviceService.selectDepartmentById(e.getDepartmentId()));
        }
        return deviceKeepers;
    }

    @ResponseBody
    @RequestMapping("deviceList/insert")
    public ResponseVo insertDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = deviceService.insertDevice(devicePlus);
        return responseVo;
    }

}
