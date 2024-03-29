package com.cskaoyan.service.plan.impl;

import com.cskaoyan.bean.plan.Task;
import com.cskaoyan.bean.plan.TaskExample;
import com.cskaoyan.mapper.plan.TaskMapper;
import com.cskaoyan.service.plan.TaskService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> getTask() {
        List<Task> taskList = taskMapper.selectByExample(new TaskExample());
        return taskList;
    }

    @Override
    public PageVo getPage(int page, int rows) {
        List<Task> materials = getTask();
        PageVo pages = PageTool.getPageVo(materials, page, rows);
        return pages;
    }

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

    @Override
    public PageVo searchTaskByTaskId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdLike(searchValue);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageVo pages = PageTool.getPageVo(tasks, page, rows);
        return pages;
    }

    @Override
    public PageVo searchTaskByTaskWorkId(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andWorkIdLike(searchValue);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageVo pages = PageTool.getPageVo(tasks, page, rows);
        return pages;
    }

    @Override
    public PageVo searchTaskByTaskManufactureSn(String searchValue, int page, int rows) {
        searchValue = "%" + searchValue + "%";
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andManufactureSnLike(searchValue);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        PageVo pages = PageTool.getPageVo(tasks, page, rows);
        return pages;
    }
}
