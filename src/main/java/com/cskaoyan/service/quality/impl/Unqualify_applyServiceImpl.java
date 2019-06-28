package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.Unqualify_apply;
import com.cskaoyan.bean.Unqualify_applyExample;
import com.cskaoyan.mapper.Unqualify_applyMapper;
import com.cskaoyan.service.quality.Unqualify_applyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Unqualify_applyServiceImpl implements Unqualify_applyService {
    @Autowired
    Unqualify_applyMapper unqualify_applyMapper;

    @Override
    public List<Unqualify_apply> selectAll() {
        return unqualify_applyMapper.selectAll();
    }

    @Override
    public List<Unqualify_apply> fuzzyquery(String pname) {
        return unqualify_applyMapper.fuzzyquery(pname);
    }

    @Override
    public int countAll() {
        return unqualify_applyMapper.countAll();
    }

    @Override
    public long countByExample(Unqualify_applyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(Unqualify_applyExample example) {
        int i = unqualify_applyMapper.deleteByExample(example);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(String unqualifyApplyId) {
        return 0;
    }

    @Override
    public int insert(Unqualify_apply record) {
        return 0;
    }

    @Override
    public int insertSelective(Unqualify_apply record) {
        return 0;
    }

    @Override
    public List<Unqualify_apply> selectByExample(Unqualify_applyExample example) {
        return null;
    }

    @Override
    public Unqualify_apply selectByPrimaryKey(String unqualifyApplyId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Unqualify_apply record, Unqualify_applyExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Unqualify_apply record, Unqualify_applyExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Unqualify_apply record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Unqualify_apply record) {
        return 0;
    }
}
