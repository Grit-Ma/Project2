package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
@Controller
public class HomeController {
    @RequestMapping("home")
    public String home() {
        return "/WEB-INF/jsp/home.jsp";
    }

=======

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
>>>>>>> 98ca399295314fb6c92e4e5168e3e86ec5cef183
}
