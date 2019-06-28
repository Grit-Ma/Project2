package com.cskaoyan.service;

import com.cskaoyan.bean.Work;

import java.util.List;

public interface WorkService {
    List<Work> workPage(int page, int rows);
}
