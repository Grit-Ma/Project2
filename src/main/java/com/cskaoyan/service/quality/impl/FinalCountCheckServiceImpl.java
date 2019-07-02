package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.FinalCountCheck;
import com.cskaoyan.bean.quality.FinalCountCheckExample;
import com.cskaoyan.mapper.quality.FinalCountCheckMapper;
import com.cskaoyan.service.quality.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper final_countCheckMapper;


    @Override
    public List<FinalCountCheck> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_countCheckMapper.selectByPage(limit,offset);
    }

    @Override
    public List<FinalCountCheck> fuzzyQueryByCountCheckId(int page, int rows, String cid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_countCheckMapper.fuzzyQueryByCountCheckId(limit,offset,cid);
    }

    @Override
    public List<FinalCountCheck> fuzzyQueryByCountOrderId(int page, int rows, String oid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_countCheckMapper.fuzzyQueryByCountOrderId(limit,offset,oid);
    }

    @Override
    public long countByExample(FinalCountCheckExample example) {
        return final_countCheckMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FinalCountCheckExample example) {
        return final_countCheckMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String fCountCheckId) {
        return final_countCheckMapper.deleteByPrimaryKey(fCountCheckId);
    }

    @Override
    public int insert(FinalCountCheck record) {
        return final_countCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(FinalCountCheck record) {
        return final_countCheckMapper.insertSelective(record);
    }

    @Override
    public List<FinalCountCheck> selectByExample(FinalCountCheckExample example) {
        return final_countCheckMapper.selectByExample(example);
    }

    @Override
    public FinalCountCheck selectByPrimaryKey(String fCountCheckId) {
        return final_countCheckMapper.selectByPrimaryKey(fCountCheckId);
    }

    @Override
    public int updateByExampleSelective(FinalCountCheck record, FinalCountCheckExample example) {
        return final_countCheckMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(FinalCountCheck record, FinalCountCheckExample example) {
        return final_countCheckMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(FinalCountCheck record) {
        return final_countCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FinalCountCheck record) {
        return final_countCheckMapper.updateByPrimaryKey(record);
    }
}
