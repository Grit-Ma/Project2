package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> manufacturePage(int page, int rows) ;
}
