package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.Process_count_check;
import com.cskaoyan.bean.quality.Process_count_checkExample;
import com.cskaoyan.mapper.quality.Process_count_checkMapper;
import com.cskaoyan.service.quality.Process_count_checkService;
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
    public List<Process_count_check> fuzzyQueryByPCountCheckId(int page, int rows, String cid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return process_count_checkMapper.fuzzyQueryByPCountCheckId(limit,offset,cid);
    }

    @Override
    public long countByExample(Process_count_checkExample example) {
        return process_count_checkMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Process_count_checkExample example) {
        return process_count_checkMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String pCountCheckId) {
        return process_count_checkMapper.deleteByPrimaryKey(pCountCheckId);
    }

    @Override
    public int insert(Process_count_check record) {
        return process_count_checkMapper.insert(record);
    }

    @Override
    public int insertSelective(Process_count_check record) {
        return process_count_checkMapper.insertSelective(record);
    }

    @Override
    public List<Process_count_check> selectByExample(Process_count_checkExample example) {
        return process_count_checkMapper.selectByExample(example);
    }

    @Override
    public Process_count_check selectByPrimaryKey(String pCountCheckId) {
        return process_count_checkMapper.selectByPrimaryKey(pCountCheckId);
    }

    @Override
    public int updateByExampleSelective(Process_count_check record, Process_count_checkExample example) {
        return process_count_checkMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Process_count_check record, Process_count_checkExample example) {
        return process_count_checkMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Process_count_check record) {
        return process_count_checkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Process_count_check record) {
        return process_count_checkMapper.updateByPrimaryKey(record);
    }
}
