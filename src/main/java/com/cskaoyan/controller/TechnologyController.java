package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TechnologyController {

    @RequestMapping("/")
    public String test(){
        return "/WEB-INF/jsp/home.jsp";
    }
    @RequestMapping("technology/find/{op}")
    public String techonlogyManage(@PathVariable("op") String op){
        System.out.println(op);
        return "";
    }
}
