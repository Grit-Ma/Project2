package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import com.github.pagehelper.PageHelper;
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
        criteria.andProductIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    @Override
    public int productAdd(Product product) {
        int insert = productMapper.insert(product);
        return insert  != 0 ? 1 : 0;
    }

    @Override
    public int productUpdate(Product product) {
        int update = productMapper.updateByPrimaryKey(product);
        return update  != 0 ? 1 : 0;
    }

    @Override
    public int productDelete(String ids) {
        int delete = productMapper.deleteByPrimaryKey(ids);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<Product> productGetData() {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdIsNotNull();
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }
}
