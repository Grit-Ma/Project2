package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.technologyService.TechnologyProcessServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyProcessServiceImpl implements TechnologyProcessServie {
    @Autowired
    ProcessMapper processMapper;

    @Override
    public List<Process> queyProcess(int page, int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<Process> list = processMapper.queyProcessByPageAndRows(number, offset);
        return list;
    }

    @Override
    public int queryTotalProcess() {
        int total = processMapper.queryTotalProcess();
        return total;
    }

    @Override
    public int insertProcess(Process process) {
        int insert = processMapper.insert(process);
        return insert;
    }

    @Override
    public int updateProcess(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        return i;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int i = processMapper.deleteBatch(ids);
        return i;
    }

    @Override
    public List<Process> searchByProcessId(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<Process> list = processMapper.searchByProcessIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByProcessIdTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = processMapper.searchByProcessTotal(search,flag);
        return total;
    }

    @Override
    public List<Process> searchByProcessByPlanId(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<Process> list = processMapper.searchByProcessIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByProcessByPlanIdTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = processMapper.searchByProcessTotal(search,flag);
        return total;
    }
}
