package com.cskaoyan.controller.device;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.bean.quality.Final_measuret_check;
import com.cskaoyan.service.device.DeviceFaultService;
import com.cskaoyan.service.device.DeviceMaintainService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Controller
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @Autowired
    DeviceFaultService deviceFaultService;

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

    @ResponseBody
    @RequestMapping("deviceFault/get/{Id}")
    public Device_fault searchFaultInfo(@PathVariable("Id") String Id)
    {
        return deviceFaultService.selectById(Id);
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/add_judge")
    public String gotoAddJudge() {
        return null;
    }

    @RequestMapping("deviceMaintain/add")
    public String gotoMaintainAdd() {
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/insert")
    public ResponseVo insertMaintain(Device_maintain device_maintain) {
        ResponseVo responseVo = deviceMaintainService.insertMaintain(device_maintain);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/edit_judge")
    public String gotoEditJudge() {
        return null;
    }

    @RequestMapping("deviceMaintain/edit")
    public String gotoMaintainEdit() {
        return "/WEB-INF/jsp/deviceMaintain_edit.jsp";
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/update")
    public ResponseVo updateMaintain(Device_maintain device_maintain) {
        ResponseVo responseVo = deviceMaintainService.updateMaintain(device_maintain);
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/delete_judge")
    public String gotoDeleteJudge() {
        return null;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/delete_batch")
    public ResponseVo deleteMaintain(String[] ids) {
        ResponseVo responseVo = deviceMaintainService.deleteMaintain(Arrays.asList(ids));
        return responseVo;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    public PageVo searchMaintainById(String searchValue, int page,int rows) {
        PageVo pageVo = deviceMaintainService.selectByMaintianId(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    public PageVo searchMaintainByFaultId(String searchValue, int page,int rows) {
        PageVo pageVo = deviceMaintainService.selectByFaultId(searchValue, page ,rows);
        return pageVo;
    }

    @ResponseBody
    @RequestMapping("deviceMaintain/update_note")
    public ResponseVo update_note(Device_maintain device_maintain){
        ResponseVo responseVo = deviceMaintainService.updateNote(device_maintain);
        return responseVo;
    }
}
