package com.cskaoyan.service;

import com.cskaoyan.bean.Task;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface TaskService {

    ResponseVo updateTask(Task task);

    ResponseVo insertTask(Task task);

    @Delete("delete from ")
    ResponseVo batchDeleteTaskByIds(List<String> ids);
}
