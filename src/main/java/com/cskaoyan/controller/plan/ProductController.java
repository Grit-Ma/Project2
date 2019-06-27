package com.cskaoyan.controller;

import com.cskaoyan.bean.Product;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.vo.ResponseVo;
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

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> productList(int page, int rows) {
        List<Product> productList = productService.productPage(page, rows);
        return productList;
    }

    @RequestMapping("product/add{id}")
    public String productAdd(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/product_add.jsp";
    }

    @RequestMapping("product/add_judge")
    public String productAddItem() { return "/WEB-INF/jsp/product_add.jsp"; }

    @RequestMapping("product/insert")
    @ResponseBody
    public ResponseVo productInsert(Product product) {
        int i = productService.productAdd(product);
        if (i == 1) {
            return new ResponseVo(200, product, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("product/edit{id}")
    public String productEdit(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/product_edit.jsp";
    }

    @RequestMapping("product/edit_judge")
    public String productEditItem() { return "/WEB-INF/jsp/product_edit.jsp"; }

    @RequestMapping("product/update_all")
    @ResponseBody
    public ResponseVo productUpdate(Product product) {
        int i = productService.productUpdate(product);
        if (i == 1) {
            return new ResponseVo(200, product, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("product/delete_judge")
    public String productDeleteItem() { return "/WEB-INF/jsp/product_edit.jsp"; }

    @RequestMapping("product/delete_batch")
    @ResponseBody
    public ResponseVo productDelete(String ids) {
        int i = productService.productDelete(ids);
        if (i == 1) {
            return new ResponseVo(200, null, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> productGet() {
        List<Product> productList = productService.productGetData();
        return productList;
    }
}
