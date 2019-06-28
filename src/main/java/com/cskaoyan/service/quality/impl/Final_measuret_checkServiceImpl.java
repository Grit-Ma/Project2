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
    public long countByExample(Final_measuret_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(Final_measuret_checkExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String fMeasureCheckId) {
        return 0;
    }

    @Override
    public int insert(Final_measuret_check record) {
        return 0;
    }

    @Override
    public int insertSelective(Final_measuret_check record) {
        return 0;
    }

    @Override
    public List<Final_measuret_check> selectByExample(Final_measuret_checkExample example) {
        return null;
    }

    @Override
    public Final_measuret_check selectByPrimaryKey(String fMeasureCheckId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Final_measuret_check record, Final_measuret_checkExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Final_measuret_check record, Final_measuret_checkExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Final_measuret_check record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Final_measuret_check record) {
        return 0;
    }
}
