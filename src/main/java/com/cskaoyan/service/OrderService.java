package com.cskaoyan.service;

import com.cskaoyan.bean.Order;
import com.cskaoyan.vo.PageVo;

import java.util.List;

public interface OrderService {
    PageVo orderPage(int page, int rows);

    int orderAdd(Order order);

    int orderUpdate(Order  order);

    int orderDelete(List<String> ids);

    List<Order> searchByOrderId(String id, int page, int rows);

    PageVo searchByOrderCustom(String custom, int page, int rows);

    PageVo searchByOrderProduct(String product, int page, int rows);

    List<Order> orderGetData();

    Order orderGet(String id);
}
