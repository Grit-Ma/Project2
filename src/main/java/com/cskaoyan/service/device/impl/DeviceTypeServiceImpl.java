package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.bean.device.DeviceTypeExample;
import com.cskaoyan.mapper.device.DeviceTypeMapper;
import com.cskaoyan.service.device.DeviceTypeService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public DeviceType selectTypeById(String typeId) {
        return deviceTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<DeviceType> selectAllType(){
        return deviceTypeMapper.selectAllType();
    }

    @Override
    public ResponseVo insertType(DeviceType device_type){
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceTypeMapper.insert(device_type);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateType(DeviceType device_type){
        ResponseVo responseVo = new ResponseVo();
        try{
            deviceTypeMapper.updateByPrimaryKey(device_type);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo deleteType(List<String> ids){
        ResponseVo responseVo = new ResponseVo();
        DeviceTypeExample example = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceTypeIdIn(ids);
        try{
            deviceTypeMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo selectByTypeId(String searchValue, int page, int rows) {
        DeviceTypeExample example = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceTypeIdLike("%" + searchValue + "%");
        List<DeviceType> device_types = deviceTypeMapper.selectByExample(example);
        PageVo pages = PageTool.getPageVo(device_types, page, rows);
        return pages;
    }

    @Override
    public PageVo selectByTypeName(String searchValue, int page, int rows) {
        DeviceTypeExample example = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDeviceTypeNameLike("%" + searchValue + "%");
        List<DeviceType> device_types = deviceTypeMapper.selectByExample(example);
        PageVo pages = PageTool.getPageVo(device_types, page, rows);
        return pages;
    }

    @Override
    public PageVo getPage(int page, int rows, List<DeviceType> device_types) {
        PageVo pages = PageTool.getPageVo(device_types, page, rows);
        return pages;
    }
}
