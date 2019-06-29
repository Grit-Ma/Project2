package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.service.device.DeviceMaintainService;
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
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("device/deviceMaintain")
    public String gotoMaintain(){
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/list")
    public PageVo selectAllMaintain(int page, int rows){
        List<Device_maintain> device_maintains = deviceMaintainService.selectAllMaintain();
        PageVo pageVo = deviceMaintainService.getPage(page, rows, device_maintains);
        return pageVo;
    }
}
