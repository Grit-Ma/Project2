package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.service.material.MaterialService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("material/find")
    public String find(){
        return "/WEB-INF/jsp/material_list.jsp";
    }

    @RequestMapping("material/list")
    @ResponseBody
    public PageVo list(int page, int rows){
        PageVo pageVo = materialService.getPage(page, rows);
        return pageVo;
    }

    @RequestMapping("material/edit")
    public String edit(){
        return "/WEB-INF/jsp/material_edit.jsp";
    }

    @RequestMapping("material/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseVo update_all(Material material){
        ResponseVo responseVo = materialService.updateMaterial(material);
        return responseVo;
    }

    @RequestMapping("material/search_material_by_materialId")
    @ResponseBody
    public PageVo search_material_by_materialId(String searchValue, int page, int rows){
        PageVo pageVo = materialService.searchMaterialByMaterialId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("material/search_material_by_materialType")
    @ResponseBody
    public PageVo search_material_by_materialType(String searchValue, int page, int rows){
        PageVo pageVo = materialService.searchMaterialByMaterialType(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("material/update_note")
    @ResponseBody
    public ResponseVo update_note(Material material){
        ResponseVo responseVo = materialService.updateMaterialNote(material);
        return responseVo;
    }

    @RequestMapping("material/add")
    public String add(){
        return "/WEB-INF/jsp/material_add.jsp";
    }

    @RequestMapping("material/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("material/insert")
    @ResponseBody
    public ResponseVo insert(Material material){
        ResponseVo responseVo = materialService.insertMaterial(material);
        return responseVo;
    }

    @RequestMapping("material/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }


    @RequestMapping("material/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = materialService.batchDeleteMaterialByIds(Arrays.asList(ids));
        return responseVo;
    }
}
