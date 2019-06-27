package com.cskaoyan.service;

import com.cskaoyan.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> productPage(int page, int rows);
}
