package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DevicePlus;
import com.cskaoyan.bean.Device_check;
import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.service.device.DeviceCheckService;
import com.cskaoyan.service.device.DeviceService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Controller
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @Autowired
    DeviceService deviceService;

    @RequestMapping("device/deviceCheck")
    public String gotoCheck(){
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceCheck/list")
    public PageVo selectAllCheck(int page, int rows){
        List<Device_check> device_checks = deviceCheckService.selectAllCheck();
        PageVo pageVo = deviceCheckService.getPage(page, rows, device_checks);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/get/{Id}")
    public Device searchDeviceInfo(@PathVariable("Id") String Id)
    {
        return deviceService.selectDeviceById(Id);
    }


    @ResponseBody
    @RequestMapping(" deviceCheck/add_judge")
    public String gotoAddJudge() {
        return null;
    }

    @RequestMapping("deviceCheck/add")
    public String gotoAddCheck() {
        return "/WEB-INF/jsp/deviceCheck_add.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceCheck/insert")
    public ResponseVo insertCheck(Device_check device_check) {
        ResponseVo responseVo = deviceCheckService.insertCheck(device_check);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/edit_judge")
    public String gotoEditJudge(){
        return null;
    }

    @RequestMapping("deviceCheck/edit")
    public String gotoEditCheck(){
        return "/WEB-INF/jsp/deviceCheck_edit.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceCheck/update")
    public ResponseVo updateCheck(Device_check device_check) {
        ResponseVo responseVo = deviceCheckService.updateCheck(device_check);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/delete_judge")
    public String gotoDeleteJudge() {
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/delete_batch")
    public ResponseVo deleteCheck(String[] ids) {
        ResponseVo responseVo = deviceCheckService.deleteCheck(Arrays.asList(ids));
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    public PageVo searchCheckByDeviceName(String searchValue, int page,int rows) {
        PageVo pageVo = deviceCheckService.selectByName(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    public PageVo searchCheckByCheckId(String searchValue, int page,int rows) {
        PageVo pageVo = deviceCheckService.selectByCheckId(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceList/update_all")
    public ResponseVo updateDeviceAll(DevicePlus devicePlus){
        ResponseVo responseVo = deviceService.updateDevice(devicePlus);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceCheck/update_note")
    public ResponseVo update_note(Device_check device_check){
        ResponseVo responseVo = deviceCheckService.updateNote(device_check);
        return responseVo;
    }

}
