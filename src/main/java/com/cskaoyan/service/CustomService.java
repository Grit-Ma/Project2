package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;

import java.util.List;

public interface CustomService {
    List<Custom> customPage(int page, int rows);

    int customAdd(Custom custom);

    int customUpdate(Custom custom);

    int customDelete(String ids);

    List<Custom> customGetData();
}
