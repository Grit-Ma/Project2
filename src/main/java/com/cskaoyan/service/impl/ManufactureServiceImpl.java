package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<Manufacture> manufacturePage(int page, int rows) {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andManufactureSnIsNotNull();
        PageHelper.startPage(page, rows);
        List<Manufacture> manufactureList = manufactureMapper.selectByExample(manufactureExample);
        return manufactureList;
    }

    @Override
    public Manufacture manufactureGet(String id) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(id);
        return manufacture;
    }

    @Override
<<<<<<< HEAD
    public List<Manufacture> manufactureGetData() {
        ManufactureExample manufactureExample = new ManufactureExample();
        ManufactureExample.Criteria criteria = manufactureExample.createCriteria();
        criteria.andManufactureSnIsNotNull();
        List<Manufacture> manufactureList = manufactureMapper.selectByExample(manufactureExample);
        return manufactureList;
=======
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
>>>>>>> 3de0c9461739f158f94aee34fa3eeae93b9f314b
    }
}
