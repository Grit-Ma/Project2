package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;

import java.util.List;

public interface CustomService {
    List<Custom> customPage(int page, int rows);

    int customAdd(Custom custom);

    int customUpdate(Custom custom);

    int customDelete(List<String > ids);

    List<Custom> searchByCustomId(String id, int page, int rows);

    List<Custom> searchByCustomName(String name, int page, int rows);

    List<Custom> customGetData();

    Custom customGet(String id);
}
