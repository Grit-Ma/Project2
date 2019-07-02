package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.bean.device.DeviceCheckExample;
import com.cskaoyan.mapper.device.DeviceCheckMapper;
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
    DeviceCheckMapper device_checkMapper;

    @Override
    public PageVo getPage(int page, int rows, List<DeviceCheck> device_checks){
        PageVo pages = PageTool.getPageVo(device_checks, page, rows);
        return pages;
    }

    @Override
    public List<DeviceCheck> selectAllCheck(){
        List<DeviceCheck> device_checks = device_checkMapper.selectAllCheck();
        return device_checks;
    }


    @Override
    public ResponseVo insertCheck(DeviceCheck device_check) {
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
    public ResponseVo updateCheck(DeviceCheck device_check) {
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
        DeviceCheckExample example = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = example.createCriteria();
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
        List<DeviceCheck> devicePluses = device_checkMapper.selectByName(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByCheckId(String searchValue, int page, int rows) {
        List<DeviceCheck> devicePluses = device_checkMapper.selectByCheckId(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateNote(DeviceCheck device_check) {
        DeviceCheck device_check1 = device_checkMapper.selectByPrimaryKey(device_check.getDeviceCheckId());
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
