package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Process;

import java.util.List;

public interface TechnologyProcessServie {
    List<Process> queyProcess(int page, int rows);

    int queryTotalProcess();

    int insertProcess(Process process);

    int updateProcess(Process process);

    int deleteBatch(String[] ids);

    List<Process> searchByProcessId(String searchValue, int page, int rows, String flag);

    int searchByProcessIdTotal(String searchValue, String flag);

    List<Process> searchByProcessByPlanId(String searchValue, int page, int rows, String flag);

    int searchByProcessByPlanIdTotal(String searchValue, String flag);

    List<Process> queryAllProcess();

}
