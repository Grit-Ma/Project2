package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Technology_plan;
import com.cskaoyan.mapper.Technology_planMapper;
import com.cskaoyan.service.technologyService.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    Technology_planMapper planMapper;
    @Override
    public List<Technology_plan> queyTechonlogyPlan(int page, int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<Technology_plan> list = planMapper.selectTecnologyPlanByPageAndRows(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechnologyPlan() {
        int total = planMapper.queryTotalTechonlogyPlan();
        return total;
    }
}
