package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("material/find")
    public String getFind(){
        return "/WEB-INF/jsp/material_list.jsp";
    }

    @RequestMapping("material/list")
    @ResponseBody
    public PageVo getList(int page, int rows){
        PageVo pageVo = materialService.getPage(page, rows);
        return pageVo;
    }
}
