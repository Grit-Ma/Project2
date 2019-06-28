package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.Work;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("task/find{id}")
    public String taskPage(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/task_list.jsp";
    }

    @RequestMapping("task/list")
    @ResponseBody
    public List<Task> taskPage(int page, int rows) {
        List<Task> taskList = taskService.taskPage(page, rows);
        return taskList;
    }
}
