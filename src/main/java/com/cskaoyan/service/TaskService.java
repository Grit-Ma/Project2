package com.cskaoyan.service;

import com.cskaoyan.bean.Task;

import java.util.List;

public interface TaskService {
    List<Task> taskPage(int page, int rows);
}
