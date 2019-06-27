package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialExample;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.service.MaterialService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> getMaterial() {
        List<Material> materialList = materialMapper.selectByExample(new MaterialExample());
        return materialList;
    }

    @Override
    public List<Material> getMaterial_by_materialId(String searchValue) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdLike(searchValue);
        List<Material> materialList = materialMapper.selectByExample(materialExample);
        return materialList;
    }

    @Override
    public PageVo getPage(int page, int rows) {
        List<Material> materials = getMaterial();
        PageVo pages = PageTool.getPageVo(materials, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateMaterial(Material material) {
        ResponseVo responseVo = new ResponseVo();
        try{
            materialMapper.updateByPrimaryKey(material);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertMaterial(Material material) {
        ResponseVo responseVo = new ResponseVo();
        try{
            materialMapper.insert(material);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteMaterialByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria = example.createCriteria();
        criteria.andMaterialIdIn(ids);
        try{
            materialMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo updateMaterialNote(Material material) {
        Material material1 = materialMapper.selectByPrimaryKey(material.getMaterialId());
        material1.setNote(material.getNote());
        ResponseVo responseVo = new ResponseVo();
        try{
            materialMapper.updateByPrimaryKey(material1);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo search_material_by_materialId(String searchValue, int page, int rows) {
        List<Material> materials = getMaterial_by_materialId(searchValue);
        PageVo pages = PageTool.getPageVo(materials, page, rows);
        return pages;
    }

}
