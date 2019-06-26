package com.cskaoyan.controller;

import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping()
public class SysController {
    @Autowired
    UserService userService;

    @RequestMapping("user/find")
    public String find(){
        return "/WEB-INF/jsp/user_list.jsp";
    }

    @RequestMapping("user/list")
    @ResponseBody
    public HashMap<String, Object> list(int page, int rows){
        HashMap<String, Object> json = userService.getJson(page, rows);
        return json;
    }


}
