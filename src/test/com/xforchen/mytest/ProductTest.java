package com.xforchen.mytest;

import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class ProductTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Test
    public  void  test() {

    }
}
