package com.cskaoyan.service;

import com.cskaoyan.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> productPage(int page, int rows);

    int productAdd(Product product);

    int productUpdate(Product product);

    int productDelete(List<String> ids);

    List<Product> searchById(String id, int page, int rows);

    List<Product> searchByName(String name, int page, int rows);

    List<Product> searchByType(String type, int page, int rows);

    List<Product> productGetData();

    Product productGet(String id);
}
