package com.cskaoyan.controller.device;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.service.device.DeviceKeeperService;
import com.cskaoyan.service.device.DeviceService;
import com.cskaoyan.service.device.DeviceTypeService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    DepartmentService departmentService;

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
    public PageVo selectAllType(int page, int rows) {
        List<Device_type> device_types = deviceTypeService.selectAllType();
        PageVo pageVo = deviceTypeService.getPage(page, rows, device_types);
        return pageVo;
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
        Employee employee = deviceKeeperService.selectEmpById(EmpId);
        return  employee;
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
    public List<Employee> selectAllEmp() {

        List<Employee> employees = deviceKeeperService.selectAllEmp();
        return employees;
    }

    @ResponseBody
    @RequestMapping("deviceList/insert")
    public ResponseVo insertDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = deviceService.insertDevice(devicePlus);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/get_data")
    public List<Device> searchAllDevice() {
        return deviceService.selectAllDevice();
    }

    @ResponseBody
    @RequestMapping("deviceList/edit_judge")
    public String gotoEditJudge() {
        return null;
    }

    @RequestMapping("deviceList/edit")
    public String gotoEdit() {
        return "/WEB-INF/jsp/deviceList_edit.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceList/update")
    public ResponseVo updateDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = deviceService.updateDevice(devicePlus);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/delete_judge")
    public String gotoDeleteJudge() {
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceList/delete_batch")
    public ResponseVo deleteDevice(String[] ids) {
        ResponseVo responseVo = deviceService.deleteDevice(Arrays.asList(ids));
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/search_device_by_deviceId")
    public PageVo searchDeviceByDeviceId(String searchValue, int page,int rows) {
        PageVo pageVo = deviceService.selectById(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/search_device_by_deviceName")
    public PageVo searchDeviceByDeviceName(String searchValue, int page,int rows) {
        PageVo pageVo = deviceService.selectByName(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public PageVo searchDeviceByDeviceTypeName(String searchValue, int page,int rows) {
        PageVo pageVo = deviceService.selectByTypeName(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/update_note")
    public ResponseVo update_note(Device device){
        ResponseVo responseVo = deviceService.updateNote(device);
        return responseVo;
    }
}
