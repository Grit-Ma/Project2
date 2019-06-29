package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.device.DeviceService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/26
 */

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> selectAllDevice() {
        List<Device> devices = deviceMapper.selectAllDevice();
        return devices;
    }

    @Override
    public PageVo getPage(int page, int rows, List<DevicePlus> devicePluses) {
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public ResponseVo insertDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceMapper.insert(devicePlus);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateDevice(DevicePlus devicePlus) {
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceMapper.updateByPrimaryKey(devicePlus);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }


    @Override
    public ResponseVo deleteDevice(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        DeviceExample example = new DeviceExample();
        DeviceExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceIdIn(ids);
        try{
            deviceMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo selectById(String searchValue, int page, int rows) {
        List<DevicePlus> devicePluses = deviceMapper.selectById(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByName(String searchValue, int page, int rows) {
        List<DevicePlus> devicePluses = deviceMapper.selectByName(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByTypeName(String searchValue, int page, int rows) {
        List<DevicePlus> devicePluses = deviceMapper.selectByTypeName(searchValue);
        PageVo pages = PageTool.getPageVo(devicePluses, page, rows);
        return pages;
    }

    @Override
    public Device selectDeviceById(String Id) {
        return deviceMapper.selectByPrimaryKey(Id);
    }

    @Override
    public ResponseVo updateNote(Device device) {
        Device device1 = deviceMapper.selectByPrimaryKey(device.getDeviceId());
        device1.setNote(device.getNote());
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceMapper.updateByPrimaryKey(device1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
