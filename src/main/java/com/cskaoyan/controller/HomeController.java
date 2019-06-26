package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }

    @RequestMapping("login")
    public String login(){
        return "/WEB-INF/jsp/login.jsp";
    }
}
