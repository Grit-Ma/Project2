package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.bean.Process_count_checkExample;
import com.cskaoyan.mapper.Process_count_checkMapper;
import com.cskaoyan.service.Process_count_checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Process_count_checkServiceImpl implements Process_count_checkService {
    @Autowired
    Process_count_checkMapper process_count_checkMapper;

    @Override
    public List<Process_count_check> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return process_count_checkMapper.selectByPage(limit,offset);
    }

    @Override
    public long countByExample(Process_count_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(Process_count_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String pCountCheckId) {
        return 0;
    }

    @Override
    public int insert(Process_count_check record) {
        return 0;
    }

    @Override
    public int insertSelective(Process_count_check record) {
        return 0;
    }

    @Override
    public List<Process_count_check> selectByExample(Process_count_checkExample example) {
        return null;
    }

    @Override
    public Process_count_check selectByPrimaryKey(String pCountCheckId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Process_count_check record, Process_count_checkExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Process_count_check record, Process_count_checkExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Process_count_check record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Process_count_check record) {
        return 0;
    }
}
