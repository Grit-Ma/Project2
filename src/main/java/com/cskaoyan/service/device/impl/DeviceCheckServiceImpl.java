package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.Device_checkMapper;
import com.cskaoyan.service.device.DeviceCheckService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    Device_checkMapper device_checkMapper;

    @Override
    public PageVo getPage(int page, int rows, List<Device_check> device_checks){
        PageVo pages = PageTool.getPageVo(device_checks, page, rows);
        return pages;
    }

    @Override
    public List<Device_check> selectAllCheck(){
        List<Device_check> device_checks = device_checkMapper.selectAllCheck();
        return device_checks;
    }


    @Override
    public ResponseVo insertCheck(Device_check device_check) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_checkMapper.insert(device_check);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateCheck(Device_check device_check) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_checkMapper.updateByPrimaryKey(device_check);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo deleteCheck(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        Device_checkExample example = new Device_checkExample();
        Device_checkExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceCheckIdIn(ids);
        try{
            device_checkMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo selectByName(String searchValue, int page, int rows) {
        List<Device_check> devicePluses = device_checkMapper.selectByName(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByCheckId(String searchValue, int page, int rows) {
        List<Device_check> devicePluses = device_checkMapper.selectByCheckId(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateNote(Device_check device_check) {
        Device_check device_check1 = device_checkMapper.selectByPrimaryKey(device_check.getDeviceCheckId());
        device_check1.setDeviceCheckResult(device_check.getDeviceCheckResult());
        ResponseVo responseVo = new ResponseVo();
        try{
            device_checkMapper.updateByPrimaryKey(device_check1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
