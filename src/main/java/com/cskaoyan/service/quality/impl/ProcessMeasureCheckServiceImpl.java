package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.ProcessMeasureCheck;
import com.cskaoyan.bean.quality.ProcessMeasureCheckExample;
import com.cskaoyan.mapper.quality.ProcessMeasureCheckMapper;
import com.cskaoyan.service.quality.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper process_measureCheckMapper;

    @Override
    public List<ProcessMeasureCheck> selectByPage(int page, int rows) {
        int limit=rows;
        int offset=(page-1)*rows;
        return process_measureCheckMapper.selectByPage(limit,offset);
    }

    @Override
    public List<ProcessMeasureCheck> fuzzyQueryByPMeasureCheckId(int page, int rows, String pid) {
        int limit=rows;
        int offset=(page-1)*rows;
        return process_measureCheckMapper.fuzzyQueryByPMeasureCheckId(limit,offset,pid);
    }

    @Override
    public long countByExample(ProcessMeasureCheckExample example) {
        return process_measureCheckMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProcessMeasureCheckExample example) {
        return process_measureCheckMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String pMeasureCheckId) {
        return process_measureCheckMapper.deleteByPrimaryKey(pMeasureCheckId);
    }

    @Override
    public int insert(ProcessMeasureCheck record) {
        return process_measureCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(ProcessMeasureCheck record) {
        return process_measureCheckMapper.insertSelective(record);
    }

    @Override
    public List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example) {
        return process_measureCheckMapper.selectByExample(example);
    }

    @Override
    public ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId) {
        return process_measureCheckMapper.selectByPrimaryKey(pMeasureCheckId);
    }

    @Override
    public int updateByExampleSelective(ProcessMeasureCheck record, ProcessMeasureCheckExample example) {
        return process_measureCheckMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProcessMeasureCheck record, ProcessMeasureCheckExample example) {
        return process_measureCheckMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProcessMeasureCheck record) {
        return process_measureCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProcessMeasureCheck record) {
        return process_measureCheckMapper.updateByPrimaryKey(record);
    }
}
