package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.service.device.DeviceFaultService;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
