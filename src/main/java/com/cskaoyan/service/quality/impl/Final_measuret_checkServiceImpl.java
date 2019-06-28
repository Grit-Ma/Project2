package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.Final_measuret_check;
import com.cskaoyan.bean.Final_measuret_checkExample;
import com.cskaoyan.mapper.Final_measuret_checkMapper;
import com.cskaoyan.service.quality.Final_measuret_checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Final_measuret_checkServiceImpl implements Final_measuret_checkService {

    @Autowired
    Final_measuret_checkMapper final_measuret_checkMapper;

    @Override
    public List<Final_measuret_check> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuret_checkMapper.selectByPage(limit,offset);
    }

    @Override
    public List<Final_measuret_check> fuzzyQueryByPid(int page, int rows, String pid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuret_checkMapper.fuzzyQueryByPid(limit,offset,pid);
    }

    @Override
    public List<Final_measuret_check> fuzzyQueryByOid(int page, int rows, String oid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuret_checkMapper.fuzzyQueryByOid(limit,offset,oid);
    }

    @Override
    public long countByExample(Final_measuret_checkExample example) {
        return final_measuret_checkMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Final_measuret_checkExample example) {
        return final_measuret_checkMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String fMeasureCheckId) {
        return final_measuret_checkMapper.deleteByPrimaryKey(fMeasureCheckId);
    }

    @Override
    public int insert(Final_measuret_check record) {
        return final_measuret_checkMapper.insert(record);
    }

    @Override
    public int insertSelective(Final_measuret_check record) {
        return final_measuret_checkMapper.insertSelective(record);
    }

    @Override
    public List<Final_measuret_check> selectByExample(Final_measuret_checkExample example) {
        return final_measuret_checkMapper.selectByExample(example);
    }

    @Override
    public Final_measuret_check selectByPrimaryKey(String fMeasureCheckId) {
        return final_measuret_checkMapper.selectByPrimaryKey(fMeasureCheckId);
    }

    @Override
    public int updateByExampleSelective(Final_measuret_check record, Final_measuret_checkExample example) {
        return final_measuret_checkMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Final_measuret_check record, Final_measuret_checkExample example) {
        return final_measuret_checkMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Final_measuret_check record) {
        return final_measuret_checkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Final_measuret_check record) {
        return final_measuret_checkMapper.updateByPrimaryKey(record);
    }
}
