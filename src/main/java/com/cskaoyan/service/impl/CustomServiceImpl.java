package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomExample;
import com.cskaoyan.bean.Product;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> customPage(int page, int rows) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Custom> customList = customMapper.selectByExample(customExample);
        return customList;
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
    public int customDelete(String ids) {
        int delete = customMapper.deleteByPrimaryKey(ids);
        return delete  != 0 ? 1 : 0;
    }

    @Override
    public List<Custom> customGetData() {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdIsNotNull();
        List<Custom> customList = customMapper.selectByExample(customExample);
        return customList;
    }
}
