package com.cskaoyan.controller.plan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManufactureController {
    @RequestMapping("manufacture/find{id}")
    public String productManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }
}
