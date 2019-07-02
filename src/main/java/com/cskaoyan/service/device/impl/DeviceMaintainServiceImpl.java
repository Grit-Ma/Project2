package com.cskaoyan.service.device.impl;


import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.bean.device.DeviceMaintainExample;
import com.cskaoyan.mapper.device.DeviceMaintainMapper;
import com.cskaoyan.service.device.DeviceMaintainService;
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
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper device_maintainMapper;

    @Override
    public PageVo getPage(int page, int rows, List<DeviceMaintain> device_maintains) {
        PageVo pages = PageTool.getPageVo(device_maintains, page, rows);
        return pages;
    }

    @Override
    public List<DeviceMaintain> selectAllMaintain() {
        List<DeviceMaintain> device_maintains= device_maintainMapper.selectAllMaintain();
        return device_maintains;
    }

    @Override
    public ResponseVo insertMaintain(DeviceMaintain device_maintain) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_maintainMapper.insert(device_maintain);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateMaintain(DeviceMaintain device_maintain) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_maintainMapper.updateByPrimaryKey(device_maintain);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo deleteMaintain(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        DeviceMaintainExample example = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceFaultIdIn(ids);
        try{
            device_maintainMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo selectByFaultId(String searchValue, int page, int rows) {
        List<DeviceMaintain> device_maintains = device_maintainMapper.selectByFaultId(searchValue);
        PageVo pages = PageTool.getPageVo(device_maintains, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByMaintianId(String searchValue, int page, int rows) {
        List<DeviceMaintain> device_faults = device_maintainMapper.selectByMaintainId(searchValue);
        PageVo pages = PageTool.getPageVo(device_faults, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateNote(DeviceMaintain device_maintain) {
        DeviceMaintain device_maintain1 = device_maintainMapper.selectByPrimaryKey(device_maintain.getDeviceMaintainId());
        device_maintain1.setNote(device_maintain.getNote());
        ResponseVo responseVo = new ResponseVo();
        try{
            device_maintainMapper.updateByPrimaryKey(device_maintain1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public DeviceMaintain selectByPrimaryKey(String deviceMaintainId){
        return device_maintainMapper.selectByPrimaryKey(deviceMaintainId);
    }
}
