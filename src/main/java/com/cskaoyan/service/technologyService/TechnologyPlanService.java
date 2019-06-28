package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Technology_plan;

import java.util.List;

public interface TechnologyPlanService {
    List<Technology_plan> queyTechonlogyPlan(int page, int rows);

    int queryTotalTechnologyPlan();
}
