package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.FinalMeasuretCheck;
import com.cskaoyan.bean.quality.FinalMeasuretCheckExample;
import com.cskaoyan.mapper.quality.FinalMeasuretCheckMapper;
import com.cskaoyan.service.quality.FinalMeasuretCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FinalMeasuretCheckServiceImpl implements FinalMeasuretCheckService {

    @Autowired
    FinalMeasuretCheckMapper final_measuretCheckMapper;

    @Override
    public List<FinalMeasuretCheck> selectByPage(int page, int rows) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuretCheckMapper.selectByPage(limit,offset);
    }

    @Override
    public List<FinalMeasuretCheck> fuzzyQueryByPid(int page, int rows, String pid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuretCheckMapper.fuzzyQueryByPid(limit,offset,pid);
    }

    @Override
    public List<FinalMeasuretCheck> fuzzyQueryByOid(int page, int rows, String oid) {
        int offset=(page-1)*rows;
        int limit=rows;
        return final_measuretCheckMapper.fuzzyQueryByOid(limit,offset,oid);
    }

    @Override
    public long countByExample(FinalMeasuretCheckExample example) {
        return final_measuretCheckMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(FinalMeasuretCheckExample example) {
        return final_measuretCheckMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String fMeasureCheckId) {
        return final_measuretCheckMapper.deleteByPrimaryKey(fMeasureCheckId);
    }

    @Override
    public int insert(FinalMeasuretCheck record) {
        return final_measuretCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(FinalMeasuretCheck record) {
        return final_measuretCheckMapper.insertSelective(record);
    }

    @Override
    public List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example) {
        return final_measuretCheckMapper.selectByExample(example);
    }

    @Override
    public FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId) {
        return final_measuretCheckMapper.selectByPrimaryKey(fMeasureCheckId);
    }

    @Override
    public int updateByExampleSelective(FinalMeasuretCheck record, FinalMeasuretCheckExample example) {
        return final_measuretCheckMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(FinalMeasuretCheck record, FinalMeasuretCheckExample example) {
        return final_measuretCheckMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(FinalMeasuretCheck record) {
        return final_measuretCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FinalMeasuretCheck record) {
        return final_measuretCheckMapper.updateByPrimaryKey(record);
    }
}
