package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Task;
import com.cskaoyan.bean.Work;
import com.cskaoyan.service.TaskService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("task/find")
    public String find(){
        return "/WEB-INF/jsp/task_list.jsp";
    }

    @RequestMapping("task/list")
    @ResponseBody
    public PageVo list(int page, int rows){
        PageVo pageVo = taskService.getPage(page, rows);
        return pageVo;
    }

    @RequestMapping("task/edit")
    public String edit(){
        return "/WEB-INF/jsp/task_edit.jsp";
    }

    @RequestMapping("task/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("task/update_all")
    @ResponseBody
    public ResponseVo update_all(Task task){
        ResponseVo responseVo = taskService.updateTask(task);
        return responseVo;
    }

    @RequestMapping("task/add")
    public String add(){
        return "/WEB-INF/jsp/task_add.jsp";
    }

    @RequestMapping("task/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("task/insert")
    @ResponseBody
    public ResponseVo insert(Task task){
        ResponseVo responseVo = taskService.insertTask(task);
        return responseVo;
    }

    @RequestMapping("task/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }


    @RequestMapping("task/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = taskService.batchDeleteTaskByIds(Arrays.asList(ids));
        return responseVo;
    }

    //search_task_by_taskId
    @RequestMapping("task/search_task_by_taskId")
    @ResponseBody
    public PageVo search_task_by_taskId(String searchValue, int page, int rows){
        PageVo pageVo = taskService.searchTaskByTaskId(searchValue, page, rows);
        return pageVo;
    }

    //search_task_by_taskWorkId
    @RequestMapping("task/search_task_by_taskWorkId")
    @ResponseBody
    public PageVo search_task_by_taskWorkId(String searchValue, int page, int rows){
        PageVo pageVo = taskService.searchTaskByTaskWorkId(searchValue, page, rows);
        return pageVo;
    }
    //search_task_by_taskManufactureSn
    @RequestMapping("task/search_task_by_taskManufactureSn")
    @ResponseBody
    public PageVo search_task_by_taskManufactureSn(String searchValue, int page, int rows){
        PageVo pageVo = taskService.searchTaskByTaskManufactureSn(searchValue, page, rows);
        return pageVo;
    }
}

