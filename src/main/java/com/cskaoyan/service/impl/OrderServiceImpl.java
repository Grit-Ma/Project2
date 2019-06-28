package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> orderPage(int page, int rows) {
        OrderExample OrderExample = new OrderExample();
        OrderExample.Criteria criteria = OrderExample.createCriteria();
        criteria.andOrderIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Order> orderList = orderMapper.selectByExample(OrderExample);
        return orderList;
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
    public List<Order> searchByOrderCustom(String custom, int page, int rows) {
        // c_order left join custom
        return null;
    }

    @Override
    public List<Order> searchByOrderProduct(String product, int page, int rows) {
        // c_order  left join product
        return null;
    }

    @Override
    public List<Order> orderGetData() {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdIsNotNull();
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }

    @Override
    public Order orderGet(String id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }
}
