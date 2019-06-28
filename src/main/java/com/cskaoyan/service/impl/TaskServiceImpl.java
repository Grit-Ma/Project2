package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.TaskExample;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> taskPage(int page, int rows) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTaskIdIsNotNull();
        PageHelper.startPage(page, rows);
        List<Task> taskList = taskMapper.selectByExample(taskExample);
        return taskList;
    }
}
