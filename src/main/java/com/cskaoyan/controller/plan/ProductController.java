package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.plan.Product;
import com.cskaoyan.service.plan.ProductService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public PageVo productList(int page, int rows) {
        PageVo productList = productService.productPage(page, rows);
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
    public ResponseVo productDelete(String[] ids) {
        List<String> list = new ArrayList<>();
        for (String id : ids) {
            list.add(id);
        }
        int i = productService.productDelete(list);
        if (i == 1) {
            return new ResponseVo(200, null, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("product/search_product_by_productId")
    @ResponseBody
    public List<Product> searchById(String searchValue, int page, int rows) {
        List<Product> productList = productService.searchById(searchValue, page, rows);
        return productList;
    }

    @RequestMapping("product/search_product_by_productName")
    @ResponseBody
    public List<Product> searchByName(String searchValue, int page, int rows) {
        List<Product> productList = productService.searchByName(searchValue, page, rows);
        return productList;
    }

    @RequestMapping("product/search_product_by_productType")
    @ResponseBody
    public List<Product> searchByType(String searchValue, int page, int rows) {
        List<Product> productList = productService.searchByType(searchValue, page, rows);
        return productList;
    }

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> productGetData() {
        List<Product> productList = productService.productGetData();
        return productList;
    }

    @RequestMapping("product/get/{id}")
    @ResponseBody
    public Product productGet(@PathVariable("id") String id) {
        Product product = productService.productGet(id);
        return product;
    }
}
