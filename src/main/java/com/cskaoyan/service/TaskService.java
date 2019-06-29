package com.cskaoyan.service;

import com.cskaoyan.bean.Task;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface TaskService {

    List<Task> getTask();

    PageVo getPage(int page, int rows);

    ResponseVo updateTask(Task task);

    ResponseVo insertTask(Task task);

    @Delete("delete from ")
    ResponseVo batchDeleteTaskByIds(List<String> ids);

    PageVo searchTaskByTaskId(String searchValue, int page, int rows);

    PageVo searchTaskByTaskWorkId(String searchValue, int page, int rows);

    PageVo searchTaskByTaskManufactureSn(String searchValue, int page, int rows);
}
