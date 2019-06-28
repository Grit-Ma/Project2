package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Process;

import java.util.List;

public interface TechnologyProcessServie {
    List<Process> queyProcess(int page, int rows);

    int queryTotalProcess();
}
