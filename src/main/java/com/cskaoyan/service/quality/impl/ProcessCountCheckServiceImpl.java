package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.ProcessCountCheck;
import com.cskaoyan.bean.quality.ProcessCountCheckExample;
import com.cskaoyan.mapper.quality.ProcessCountCheckMapper;
import com.cskaoyan.service.quality.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper process_countCheckMapper;

    @Override
    public List<ProcessCountCheck> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return process_countCheckMapper.selectByPage(limit,offset);
    }

    @Override
    public List<ProcessCountCheck> fuzzyQueryByPCountCheckId(int page, int rows, String cid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return process_countCheckMapper.fuzzyQueryByPCountCheckId(limit,offset,cid);
    }

    @Override
    public long countByExample(ProcessCountCheckExample example) {
        return process_countCheckMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProcessCountCheckExample example) {
        return process_countCheckMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String pCountCheckId) {
        return process_countCheckMapper.deleteByPrimaryKey(pCountCheckId);
    }

    @Override
    public int insert(ProcessCountCheck record) {
        return process_countCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(ProcessCountCheck record) {
        return process_countCheckMapper.insertSelective(record);
    }

    @Override
    public List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example) {
        return process_countCheckMapper.selectByExample(example);
    }

    @Override
    public ProcessCountCheck selectByPrimaryKey(String pCountCheckId) {
        return process_countCheckMapper.selectByPrimaryKey(pCountCheckId);
    }

    @Override
    public int updateByExampleSelective(ProcessCountCheck record, ProcessCountCheckExample example) {
        return process_countCheckMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProcessCountCheck record, ProcessCountCheckExample example) {
        return process_countCheckMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProcessCountCheck record) {
        return process_countCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProcessCountCheck record) {
        return process_countCheckMapper.updateByPrimaryKey(record);
    }
}
