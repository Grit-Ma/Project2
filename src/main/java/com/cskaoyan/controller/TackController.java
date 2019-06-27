package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TackController {
    @RequestMapping("task/find{id}")
    public String productManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/task_list.jsp";
    }
}
