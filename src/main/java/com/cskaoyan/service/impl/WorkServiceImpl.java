package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> workPage(int page, int rows) {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Work> workList = workMapper.selectByExample(workExample);
        return workList;
    }
}
