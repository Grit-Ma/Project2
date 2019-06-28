package com.cskaoyan.service;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.Custom;

import java.util.List;

public interface OrderService {
    List<Order> orderPage(int page, int rows);

    int orderAdd(Order order);

    int orderUpdate(Order  order);

    int orderDelete(List<String> ids);

    List<Order> searchByOrderId(String id, int page, int rows);

    List<Order> searchByOrderCustom(String custom, int page, int rows);

    List<Order> searchByOrderProduct(String product, int page, int rows);

    List<Order> orderGetData();
}
