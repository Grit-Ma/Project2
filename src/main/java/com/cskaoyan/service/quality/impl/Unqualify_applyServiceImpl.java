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
    public List<Unqualify_apply> fuzzyqueryByPname(String pname) {
        return unqualify_applyMapper.fuzzyqueryByPname(pname);
    }

    @Override
    public List<Unqualify_apply> fuzzyqueryByPid(String pid) {
        return unqualify_applyMapper.fuzzyqueryByPid(pid);
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
        return unqualify_applyMapper.deleteByPrimaryKey(unqualifyApplyId);
    }

    @Override
    public int insert(Unqualify_apply record) {
        return unqualify_applyMapper.insert(record);
    }

    @Override
    public int insertSelective(Unqualify_apply record) {
        return unqualify_applyMapper.insertSelective(record);
    }

    @Override
    public List<Unqualify_apply> selectByExample(Unqualify_applyExample example) {
        return unqualify_applyMapper.selectByExample(example);
    }

    @Override
    public Unqualify_apply selectByPrimaryKey(String unqualifyApplyId) {

        return unqualify_applyMapper.selectByPrimaryKey(unqualifyApplyId);
    }

    @Override
    public int updateByExampleSelective(Unqualify_apply record, Unqualify_applyExample example) {

        return unqualify_applyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Unqualify_apply record, Unqualify_applyExample example) {

        return unqualify_applyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Unqualify_apply record) {

        return unqualify_applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Unqualify_apply record) {
        return unqualify_applyMapper.updateByPrimaryKey(record);
    }
}
