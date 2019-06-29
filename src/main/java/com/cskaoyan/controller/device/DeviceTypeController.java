package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device_type;
import com.cskaoyan.service.device.DeviceTypeService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * created by ZengWei
 * on 2019/6/28
 */

@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    @ResponseBody
    @RequestMapping("deviceType/add_judge")
    public String gotoTypeAddJudge() {
        return null;
    }

    @RequestMapping("deviceType/add")
    public String gotoAddType() {
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceType/insert")
    public ResponseVo insertType(Device_type device_type){
        ResponseVo responseVo = deviceTypeService.insertType(device_type);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceType/edit_judge")
    public String gotoTypeEditJugde(){
        return null;
    }

    @RequestMapping("deviceType/edit")
    public String gotoEditType(){
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceType/update")
    public ResponseVo updateType(Device_type device_type){
        ResponseVo responseVo = deviceTypeService.updateType(device_type);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceType/update_all")
    public ResponseVo updateTypeAll(Device_type device_type){
        ResponseVo responseVo = deviceTypeService.updateType(device_type);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceType/delete_judge")
    public String gotoDeleteJudge(){
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceType/delete_batch")
    public ResponseVo deleteType(String[] ids) {
        ResponseVo responseVo = deviceTypeService.deleteType(Arrays.asList(ids));
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    public PageVo searchDeviceByDeviceId(String searchValue, int page, int rows) {
        PageVo pageVo = deviceTypeService.selectByTypeId(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    public PageVo searchDeviceByDeviceName(String searchValue, int page, int rows) {
        PageVo pageVo = deviceTypeService.selectByTypeName(searchValue, page ,rows);
        return pageVo;
    }
}
