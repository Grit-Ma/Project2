package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.plan.Custom;
import com.cskaoyan.bean.plan.CustomExample;
import com.cskaoyan.mapper.plan.CustomMapper;
import com.cskaoyan.service.plan.CustomService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public PageVo customPage(int page, int rows) {
        List<Custom> customList = customMapper.selectByExample(new CustomExample());
        PageVo pages = PageTool.getPageVo(customList, page, rows);
        return pages;
    }

    @Override
    public int customAdd(Custom custom) {
        int insert = customMapper.insert(custom);
        return insert  != 0 ? 1 : 0;
    }

    @Override
    public int customUpdate(Custom custom) {
        int update = customMapper.updateByPrimaryKey(custom);
        return update  != 0 ? 1 : 0;
    }

    @Override
    public int customDelete(List<String> ids) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdIn(ids);
        int delete = customMapper.deleteByExample(customExample);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<Custom> searchByCustomId(String id, int page, int rows) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdLike("%" + id + "%");
        PageHelper.startPage(page, rows);
        List<Custom> customList = customMapper.selectByExample(customExample);
        return customList;
    }

    @Override
    public List<Custom> searchByCustomName(String name, int page, int rows) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomNameLike("%" + name + "%");
        PageHelper.startPage(page, rows);
        List<Custom> customList = customMapper.selectByExample(customExample);
        return customList;
    }

    @Override
    public List<Custom> customGetData() {
        List<Custom> customList = customMapper.selectByExample(new CustomExample());
        return customList;
    }

    @Override
    public Custom customGet(String id) {
        Custom custom = customMapper.selectByPrimaryKey(id);
        return custom;
    }
}
