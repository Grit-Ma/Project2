package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public ResponseVo updateTask(Task task) {
        ResponseVo responseVo = new ResponseVo();
        try{
            taskMapper.updateByPrimaryKey(task);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertTask(Task task) {
        ResponseVo responseVo = new ResponseVo();
        try{
            taskMapper.insert(task);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteTaskByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andTaskIdIn(ids);
        try{
            taskMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
