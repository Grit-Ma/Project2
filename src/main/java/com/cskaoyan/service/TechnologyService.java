package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;

import java.util.List;

public interface TechnologyService {
    List<Technology> queyTechnology(int page, int rows);
}
