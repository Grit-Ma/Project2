package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.service.MaterialService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> getMaterial() {

        List<Material> materialList = materialMapper.getMaterial();
        return materialList;
    }

    @Override
    public PageVo getPage(int page, int rows) {
        List<Material> materials = getMaterial();
        PageVo pages = PageTool.getPageVo(materials, page, rows);
        return pages;
    }
}
