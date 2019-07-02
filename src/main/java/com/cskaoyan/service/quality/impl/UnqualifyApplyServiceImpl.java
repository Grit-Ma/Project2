package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.quality.UnqualifyApply;
import com.cskaoyan.bean.quality.UnqualifyApplyExample;
import com.cskaoyan.mapper.quality.UnqualifyApplyMapper;
import com.cskaoyan.service.quality.UnqualifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyApplyServiceImpl implements UnqualifyApplyService {
    @Autowired
    UnqualifyApplyMapper unqualify_applyMapper;

    @Override
    public List<UnqualifyApply> selectAll() {
        return unqualify_applyMapper.selectAll();
    }

    @Override
    public List<UnqualifyApply> fuzzyqueryByPname(String pname) {
        return unqualify_applyMapper.fuzzyqueryByPname(pname);
    }

    @Override
    public List<UnqualifyApply> fuzzyqueryByPid(String pid) {
        return unqualify_applyMapper.fuzzyqueryByPid(pid);
    }

    @Override
    public int countAll() {
        return unqualify_applyMapper.countAll();
    }

    @Override
    public long countByExample(UnqualifyApplyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(UnqualifyApplyExample example) {
        int i = unqualify_applyMapper.deleteByExample(example);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(String unqualifyApplyId) {
        return unqualify_applyMapper.deleteByPrimaryKey(unqualifyApplyId);
    }

    @Override
    public int insert(UnqualifyApply record) {
        return unqualify_applyMapper.insert(record);
    }

    @Override
    public int insertSelective(UnqualifyApply record) {
        return unqualify_applyMapper.insertSelective(record);
    }

    @Override
    public List<UnqualifyApply> selectByExample(UnqualifyApplyExample example) {
        return unqualify_applyMapper.selectByExample(example);
    }

    @Override
    public UnqualifyApply selectByPrimaryKey(String unqualifyApplyId) {

        return unqualify_applyMapper.selectByPrimaryKey(unqualifyApplyId);
    }

    @Override
    public int updateByExampleSelective(UnqualifyApply record, UnqualifyApplyExample example) {

        return unqualify_applyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UnqualifyApply record, UnqualifyApplyExample example) {

        return unqualify_applyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UnqualifyApply record) {

        return unqualify_applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UnqualifyApply record) {
        return unqualify_applyMapper.updateByPrimaryKey(record);
    }
}
