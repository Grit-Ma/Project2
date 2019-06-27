package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> productPage(int page, int rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andStatusEqualTo(1);
        // PageHelper.startPage(page, rows);
        System.out.println("start");
        List<Product> productList = productMapper.selectByExample(productExample);
        System.out.println("end");
        return productList;
    }

    @Override
    public int productAdd(Product product) {
        return 0;
    }

    @Override
    public int productUpdate(Product product) {
        return 0;
    }

    @Override
    public int productDelete(String ids) {
        return 0;
    }

    @Override
    public List<Product> productGetData() {
        return null;
    }
}
