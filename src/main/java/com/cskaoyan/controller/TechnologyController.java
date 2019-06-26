package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;
    //find处理view
    @RequestMapping("technology/find")
    public String  techonlogyManageView(){
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    //list返回json
    //pags和rows为mvc自动封装的参数(url中的)
    @RequestMapping("technology/list")
    @ResponseBody
    public HashMap<String,Object> techonlogyManage(int page,int rows){
        List<Technology> list = technologyService.queyTechnology(page,rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("page",page);
        map.put("row",rows);
        return map;
    }

}
