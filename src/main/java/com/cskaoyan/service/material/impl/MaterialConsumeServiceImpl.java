package com.cskaoyan.service.material.impl;

import com.cskaoyan.bean.material.Material_consume;
import com.cskaoyan.bean.material.Material_consumeExample;
import com.cskaoyan.mapper.material.Material_consumeMapper;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    Material_consumeMapper material_consumeMapper;

    @Override
    public List<Material_consume> getMaterialConsume() {
        List<Material_consume> material_consumeList = material_consumeMapper.selectForMaterialAndMaterialConsumeAndWork();
        return material_consumeList;
    }

    @Override
    public PageVo getPage(int page, int rows) {
        List<Material_consume> materialConsumes = getMaterialConsume();
        PageVo pages = PageTool.getPageVo(materialConsumes, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateMaterialConsume(Material_consume material_consume) {
        ResponseVo responseVo = new ResponseVo();
        try{
            material_consumeMapper.updateByPrimaryKey(material_consume);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateMaterialConsumeNote(Material_consume material_consume) {
        Material_consume material_consume1 = material_consumeMapper.selectByPrimaryKey(material_consume.getConsumeId());
        material_consume1.setNote(material_consume.getNote());
        ResponseVo responseVo = new ResponseVo();
        try{
            material_consumeMapper.updateByPrimaryKey(material_consume1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertMaterialConsume(Material_consume material_consume) {
        ResponseVo responseVo = new ResponseVo();
        try{
            material_consumeMapper.insert(material_consume);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteMaterialConsumeByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        Material_consumeExample example = new Material_consumeExample();
        Material_consumeExample.Criteria criteria = example.createCriteria();
        criteria.andConsumeIdIn(ids);
        try{
            material_consumeMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo searchMaterialConsumeByConsumeId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        List<Material_consume> material_receives = material_consumeMapper.getMaterialConsumeByConsumeId(searchValue);
        PageVo pages = PageTool.getPageVo(material_receives, page, rows);
        return pages;
    }

    @Override
    public PageVo searchMaterialConsumeByMaterialId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        List<Material_consume> material_receives = material_consumeMapper.getMaterialConsumeByMaterialId(searchValue);
        PageVo pages = PageTool.getPageVo(material_receives, page, rows);
        return pages;
    }

    @Override
    public PageVo searchMaterialConsumeByWorkId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        List<Material_consume> material_receives = material_consumeMapper.getMaterialConsumeByWorkId(searchValue);
        PageVo pages = PageTool.getPageVo(material_receives, page, rows);
        return pages;
    }
}
