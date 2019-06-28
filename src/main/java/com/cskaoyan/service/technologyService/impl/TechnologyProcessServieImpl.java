package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.technologyService.TechnologyProcessServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyProcessServieImpl implements TechnologyProcessServie {
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
}
