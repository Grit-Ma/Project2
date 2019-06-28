package com.cskaoyan.service.quality.impl;

import com.cskaoyan.bean.Process_measure_check;
import com.cskaoyan.mapper.Process_measure_checkMapper;
import com.cskaoyan.service.quality.Process_measure_checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Process_measure_checkServiceImpl implements Process_measure_checkService {
    @Autowired
    Process_measure_checkMapper process_measure_checkMapper;

    @Override
    public List<Process_measure_check> selectByPage(int page, int rows) {
        int limit=rows;
        int offset=(page-1)*rows;
        return process_measure_checkMapper.selectByPage(limit,offset);
    }
}
