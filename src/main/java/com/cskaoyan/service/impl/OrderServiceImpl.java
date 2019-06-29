package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.OrderService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageVo orderPage(int page, int rows) {
        List<Order> orderList = orderMapper.selectByExample(new OrderExample());
        PageVo pages = PageTool.getPageVo(orderList, page, rows);
        return pages;
    }

    @Override
    public int orderAdd(Order order) {
        int insert = orderMapper.insert(order);
        return insert  != 0 ? 1 : 0;
    }

    @Override
    public int orderUpdate(Order order) {
        int update = orderMapper.updateByPrimaryKey(order);
        return update  != 0 ? 1 : 0;
    }

    @Override
    public int orderDelete(List<String> ids) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdIn(ids);
        int delete = orderMapper.deleteByExample(orderExample);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<Order> searchByOrderId(String id, int page, int rows) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdLike("%" + id + "%");
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }

    @Override
    public PageVo searchByOrderCustom(String custom, int page, int rows) {
        String customName = "%" + custom + "%";
        List<Order> orderList = orderMapper.selectByCustomName(customName);
        PageVo pages = PageTool.getPageVo(orderList, page, rows);
        return pages;
    }

    @Override
    public PageVo searchByOrderProduct(String product, int page, int rows) {
        String productName = "%" + product + "%";
        List<Order> orderList = orderMapper.selectByProductName(productName);
        PageVo pages = PageTool.getPageVo(orderList, page, rows);
        return pages;
    }

    @Override
    public List<Order> orderGetData() {
        List<Order> orderList = orderMapper.selectByExample(new OrderExample());
        return orderList;
    }

    @Override
    public Order orderGet(String id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }
}
