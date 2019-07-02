package com.cskaoyan.service.device.impl;


import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.bean.device.DeviceFaultExample;
import com.cskaoyan.mapper.device.DeviceFaultMapper;
import com.cskaoyan.service.device.DeviceFaultService;
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
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper device_faultMapper;

    @Override
    public PageVo getPage(int page, int rows, List<DeviceFault> device_faults){
        PageVo pages = PageTool.getPageVo(device_faults, page, rows);
        return pages;
    }

    @Override
    public List<DeviceFault> selectAllFault(){
        List<DeviceFault> device_faults = device_faultMapper.selectAllFault();
        return device_faults;
    }

    @Override
    public ResponseVo insertFault(DeviceFault device_fault) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_faultMapper.insert(device_fault);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateFault(DeviceFault device_fault) {
        ResponseVo responseVo = new ResponseVo();
        try{
            device_faultMapper.updateByPrimaryKey(device_fault);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo deleteFault(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        DeviceFaultExample example = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceFaultIdIn(ids);
        try{
            device_faultMapper.deleteByExample(example);
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
        List<DeviceFault> device_faults = device_faultMapper.selectByName(searchValue);
        PageVo pages = PageTool.getPageVo(device_faults, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByFaultId(String searchValue, int page, int rows) {
        List<DeviceFault> device_faults = device_faultMapper.selectByFaultId(searchValue);
        PageVo pages = PageTool.getPageVo(device_faults, page, rows);
        return pages;
    }

    @Override
    public DeviceFault selectById(String faultId){
        return device_faultMapper.selectByPrimaryKey(faultId);
    }

    @Override
    public ResponseVo updateNote(DeviceFault device_fault) {
        DeviceFault device_fault1 = device_faultMapper.selectByPrimaryKey(device_fault.getDeviceFaultId());
        device_fault1.setDeviceFaultDetail(device_fault.getDeviceFaultDetail());
        ResponseVo responseVo = new ResponseVo();
        try{
            device_faultMapper.updateByPrimaryKey(device_fault1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
