package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.vo.PageVo;

import java.util.List;

public interface MaterialService {
    List<Material> getMaterial();
    PageVo getPage(int page, int rows);
}
