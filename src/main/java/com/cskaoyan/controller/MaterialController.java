package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
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

    @RequestMapping("material/edit_judge")
    public String edit(){
        return "/WEB-INF/jsp/material_edit.jsp";
    }

    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseVo update(Material material){
        ResponseVo responseVo = materialService.updateMaterial(material);
        return responseVo;
    }

    @RequestMapping("material/add")
    public String add(){
        return "/WEB-INF/jsp/material_add.jsp";
    }

    @RequestMapping("material/insert")
    @ResponseBody
    public ResponseVo insert(Material material){
        ResponseVo responseVo = materialService.insertMaterial(material);
        return responseVo;
    }

    @RequestMapping("material/delete")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = materialService.batchDeleteMaterialByIds(Arrays.asList(ids));
        return responseVo;
    }
}
