package com.cskaoyan.service.material.impl;

import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceiveExample;
import com.cskaoyan.mapper.material.MaterialReceiveMapper;
import com.cskaoyan.service.material.MaterialReceiveService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper material_receiveMapper;

    @Override
    public List<MaterialReceive> getMaterialReceive() {
        List<MaterialReceive> material_receiveList = material_receiveMapper.selectForMaterialAndMaterialReceive();
        return material_receiveList;
    }

    @Override
    public PageVo getPage(int page, int rows) {
        List<MaterialReceive> materialReceives = getMaterialReceive();
        PageVo pages = PageTool.getPageVo(materialReceives, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateMaterialReceive(MaterialReceive material_receive) {
        ResponseVo responseVo = new ResponseVo();
        try{
            material_receiveMapper.updateByPrimaryKey(material_receive);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertMaterialReceive(MaterialReceive material_receive) {
        ResponseVo responseVo = new ResponseVo();
        try{
            material_receiveMapper.insert(material_receive);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteMaterialReceiveByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        MaterialReceiveExample example = new MaterialReceiveExample();
        MaterialReceiveExample.Criteria criteria = example.createCriteria();
        criteria.andReceiveIdIn(ids);
        try{
            material_receiveMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateMaterialReceiveNote(MaterialReceive material_receive) {
        MaterialReceive material_receive1 = material_receiveMapper.selectByPrimaryKey(material_receive.getReceiveId());
        material_receive1.setNote(material_receive.getNote());
        ResponseVo responseVo = new ResponseVo();
        try{
            material_receiveMapper.updateByPrimaryKey(material_receive1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo searchMaterialReceiveByReceiveId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> material_receives = material_receiveMapper.getMaterialReceiveByReceiveId(searchValue);
        PageVo pages = PageTool.getPageVo(material_receives, page, rows);
        return pages;
    }

    @Override
    public PageVo searchMaterialReceiveByMaterialId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        List<MaterialReceive> material_receives = material_receiveMapper.getMaterialReceiveByMaterialId(searchValue);
        PageVo pages = PageTool.getPageVo(material_receives, page, rows);
        return pages;
    }

}
