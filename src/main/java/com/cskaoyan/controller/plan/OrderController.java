package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping("order/find{id}")
    public String productManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/order_list.jsp";
    }
}
