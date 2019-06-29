package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public PageVo manufacturePage(int page, int rows) {
        List<Manufacture> manufactureList = manufactureMapper.selectByExample(new ManufactureExample());
        PageVo pages = PageTool.getPageVo(manufactureList, page, rows);
        return pages;
    }

    @Override
    public Manufacture manufactureGet(String id) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(id);
        return manufacture;
    }

    @Override
    public List<Manufacture> manufactureGetData() {
        List<Manufacture> manufactureList = manufactureMapper.selectByExample(new ManufactureExample());
        return manufactureList;
    }

    @Override
    public ResponseVo updateManufacture(Manufacture manufacture) {
        ResponseVo responseVo = new ResponseVo();
        try{
            manufactureMapper.updateByPrimaryKey(manufacture);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertManufacture(Manufacture manufacture) {
        ResponseVo responseVo = new ResponseVo();
        try{
            manufactureMapper.insert(manufacture);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteManufactureByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        ManufactureExample example = new ManufactureExample();
        ManufactureExample.Criteria criteria = example.createCriteria();
        criteria.andManufactureSnIn(ids);
        try{
            manufactureMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
