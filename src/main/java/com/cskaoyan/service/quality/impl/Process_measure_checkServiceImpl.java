package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.Process_measure_check;
import com.cskaoyan.bean.quality.Process_measure_checkExample;
import com.cskaoyan.mapper.quality.Process_measure_checkMapper;
import com.cskaoyan.service.quality.Process_measure_checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Process_measure_checkServiceImpl implements Process_measure_checkService {
    @Autowired
    Process_measure_checkMapper process_measure_checkMapper;

    @Override
    public List<Process_measure_check> selectByPage(int page, int rows) {
        int limit=rows;
        int offset=(page-1)*rows;
        return process_measure_checkMapper.selectByPage(limit,offset);
    }

    @Override
    public List<Process_measure_check> fuzzyQueryByPMeasureCheckId(int page, int rows, String pid) {
        int limit=rows;
        int offset=(page-1)*rows;
        return process_measure_checkMapper.fuzzyQueryByPMeasureCheckId(limit,offset,pid);
    }

    @Override
    public long countByExample(Process_measure_checkExample example) {
        return process_measure_checkMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Process_measure_checkExample example) {
        return process_measure_checkMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String pMeasureCheckId) {
        return process_measure_checkMapper.deleteByPrimaryKey(pMeasureCheckId);
    }

    @Override
    public int insert(Process_measure_check record) {
        return process_measure_checkMapper.insert(record);
    }

    @Override
    public int insertSelective(Process_measure_check record) {
        return process_measure_checkMapper.insertSelective(record);
    }

    @Override
    public List<Process_measure_check> selectByExample(Process_measure_checkExample example) {
        return process_measure_checkMapper.selectByExample(example);
    }

    @Override
    public Process_measure_check selectByPrimaryKey(String pMeasureCheckId) {
        return process_measure_checkMapper.selectByPrimaryKey(pMeasureCheckId);
    }

    @Override
    public int updateByExampleSelective(Process_measure_check record, Process_measure_checkExample example) {
        return process_measure_checkMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Process_measure_check record, Process_measure_checkExample example) {
        return process_measure_checkMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Process_measure_check record) {
        return process_measure_checkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Process_measure_check record) {
        return process_measure_checkMapper.updateByPrimaryKey(record);
    }
}
