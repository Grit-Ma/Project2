package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Final_count_checkExample;
import com.cskaoyan.mapper.Final_count_checkMapper;
import com.cskaoyan.service.quality.Final_count_checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Final_count_checkServiceImpl implements Final_count_checkService {
    @Autowired
    Final_count_checkMapper final_count_checkMapper;


    @Override
    public List<Final_count_check> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_count_checkMapper.selectByPage(limit,offset);
    }

    @Override
    public long countByExample(Final_count_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(Final_count_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String fCountCheckId) {
        return 0;
    }

    @Override
    public int insert(Final_count_check record) {
        return 0;
    }

    @Override
    public int insertSelective(Final_count_check record) {
        return 0;
    }

    @Override
    public List<Final_count_check> selectByExample(Final_count_checkExample example) {
        return null;
    }

    @Override
    public Final_count_check selectByPrimaryKey(String fCountCheckId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Final_count_check record, Final_count_checkExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Final_count_check record, Final_count_checkExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Final_count_check record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Final_count_check record) {
        return 0;
    }
}
