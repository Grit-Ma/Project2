package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.plan.Product;
import com.cskaoyan.bean.plan.ProductExample;
import com.cskaoyan.mapper.plan.ProductMapper;
import com.cskaoyan.service.plan.ProductService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public PageVo productPage(int page, int rows) {
        List<Product> productList = productMapper.selectByExample(new ProductExample());
        PageVo pages = PageTool.getPageVo(productList, page, rows);
        return pages;
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
    public int productDelete(List<String> ids) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdIn(ids);
        int delete = productMapper.deleteByExample(productExample);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<Product> searchById(String id, int page, int rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductIdLike("%" + id + "%");
        PageHelper.startPage(page, rows);
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    @Override
    public List<Product> searchByName(String name, int page, int rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductNameLike("%" + name + "%");
        PageHelper.startPage(page, rows);
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    @Override
    public List<Product> searchByType(String type, int page, int rows) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andProductTypeLike("%" + type + "%");
        PageHelper.startPage(page, rows);
        List<Product> productList = productMapper.selectByExample(productExample);
        return productList;
    }

    @Override
    public List<Product> productGetData() {
        List<Product> productList = productMapper.selectByExample(new ProductExample());
        return productList;
    }

    @Override
    public Product productGet(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }
}
