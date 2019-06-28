package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import com.cskaoyan.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> workPage(int page, int rows) {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Work> workList = workMapper.selectByExample(workExample);
        return workList;
    }

    @Override
    public List<Work> workGetData() {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdIsNotNull();
        List<Work> workList = workMapper.selectByExample(workExample);
        return workList;
    }

    @Override
    public Work workGet(String id) {
        Work work = workMapper.selectByPrimaryKey(id);
        return work;
    }

    @Override
    public ResponseVo updateWork(Work work) {
        ResponseVo responseVo = new ResponseVo();
        try{
            workMapper.updateByPrimaryKey(work);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertWork(Work work) {
        ResponseVo responseVo = new ResponseVo();
        try{
            workMapper.insert(work);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteWorkByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        WorkExample example = new WorkExample();
        WorkExample.Criteria criteria = example.createCriteria();
        criteria.andWorkIdIn(ids);
        try{
            workMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
