package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomController {
    @RequestMapping("custom/find{id}")
    public String productManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/custom_list.jsp";
    }
}
