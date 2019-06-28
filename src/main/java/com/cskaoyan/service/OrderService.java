package com.cskaoyan.service;

import com.cskaoyan.bean.C_order;
import com.cskaoyan.bean.Custom;

import java.util.List;

public interface OrderService {
    List<C_order> orderPage(int page, int rows);

    int orderAdd(C_order order);

    int orderUpdate(C_order  order);

    int orderDelete(List<String> ids);

    List<C_order> searchByOrderId(String id, int page, int rows);

    List<C_order> searchByOrderCustom(String custom, int page, int rows);

    List<C_order> searchByOrderProduct(String product, int page, int rows);

    List<C_order> orderGetData();
}
