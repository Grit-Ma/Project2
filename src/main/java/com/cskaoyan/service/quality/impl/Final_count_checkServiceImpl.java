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
    public List<Final_count_check> fuzzyQueryByCountCheckId(int page, int rows, String cid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_count_checkMapper.fuzzyQueryByCountCheckId(limit,offset,cid);
    }

    @Override
    public List<Final_count_check> fuzzyQueryByCountOrderId(int page, int rows, String oid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_count_checkMapper.fuzzyQueryByCountOrderId(limit,offset,oid);
    }

    @Override
    public long countByExample(Final_count_checkExample example) {
        return final_count_checkMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Final_count_checkExample example) {
        return final_count_checkMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String fCountCheckId) {
        return final_count_checkMapper.deleteByPrimaryKey(fCountCheckId);
    }

    @Override
    public int insert(Final_count_check record) {
        return final_count_checkMapper.insert(record);
    }

    @Override
    public int insertSelective(Final_count_check record) {
        return final_count_checkMapper.insertSelective(record);
    }

    @Override
    public List<Final_count_check> selectByExample(Final_count_checkExample example) {
        return final_count_checkMapper.selectByExample(example);
    }

    @Override
    public Final_count_check selectByPrimaryKey(String fCountCheckId) {
        return final_count_checkMapper.selectByPrimaryKey(fCountCheckId);
    }

    @Override
    public int updateByExampleSelective(Final_count_check record, Final_count_checkExample example) {
        return final_count_checkMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Final_count_check record, Final_count_checkExample example) {
        return final_count_checkMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Final_count_check record) {
        return final_count_checkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Final_count_check record) {
        return final_count_checkMapper.updateByPrimaryKey(record);
    }
}
