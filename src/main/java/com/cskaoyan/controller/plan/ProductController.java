package com.cskaoyan.controller;

import com.cskaoyan.bean.Product;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("product/find{id}")
    public String productManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/product_list.jsp";
    }

    /*分页功能需要自己实现*/
    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> productList(int page, int rows) {
        List<Product> productList = productService.productPage(page, rows);
        return productList;
    }

}
