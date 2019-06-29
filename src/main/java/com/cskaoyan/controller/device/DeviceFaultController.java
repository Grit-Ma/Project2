package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device_check;
import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.service.device.DeviceFaultService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Controller
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("device/deviceFault")
    public String gotoFault() {
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceFault/list")
    public PageVo selectAllFault(int page, int rows){
        List<Device_fault> device_faults = deviceFaultService.selectAllFault();
        PageVo pageVo = deviceFaultService.getPage(page, rows, device_faults);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceFault/get_data")
    public List<Device_fault> getFaultData() {
        List<Device_fault> device_faults = deviceFaultService.selectAllFault();
        return device_faults;
    }

    @ResponseBody
    @RequestMapping("deviceFault/add_judge")
    public String gotoAdd(){
        return null;
    }

    @RequestMapping("deviceFault/add")
    public String gotoFaultAdd(){
        return "/WEB-INF/jsp/deviceFault_add.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceFault/insert")
    public ResponseVo insertFault(Device_fault device_fault) {
        ResponseVo responseVo = deviceFaultService.insertFault(device_fault);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceFault/edit_judge")
    public String gotoFaultJudge(){
        return null;
    }

    @RequestMapping("deviceFault/edit")
    public String gotoFaultCheck(){
        return "/WEB-INF/jsp/deviceFault_edit.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceFault/update")
    public ResponseVo updateFault(Device_fault device_fault) {
        ResponseVo responseVo = deviceFaultService.updateFault(device_fault);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceFault/delete_judge")
    public String gotoDeleteJudge() {
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceFault/delete_batch")
    public ResponseVo deleteFault(String[] ids) {
        ResponseVo responseVo = deviceFaultService.deleteFault(Arrays.asList(ids));
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    public PageVo searchFaultByDeviceName(String searchValue, int page,int rows) {
        PageVo pageVo = deviceFaultService.selectByName(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    public PageVo searchFaultByCheckId(String searchValue, int page,int rows) {
        PageVo pageVo = deviceFaultService.selectByFaultId(searchValue, page ,rows);
        return pageVo;
    }
}
