package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Technology_plan;

import java.util.List;

public interface TechnologyPlanService {
    List<Technology_plan> queyTechonlogyPlan(int page, int rows);

    int queryTotalTechnologyPlan();

    int insertTechnologyPlan(Technology_plan technologyPlan);

    int updateTechnologyPlan(Technology_plan technologyPlan);

    int deleteBatch(String[] ids);

    List<Technology_plan> queryAllTechnologyPlan();

    Technology_plan queryTechnologyPlanById(String technologyPlanId);

    List<Technology_plan> searchByTechnologyPlanId(String searchValue, int page, int rows, String flag);

    int searchByTechnologyPlanIdTotal(String searchValue, String flag);

    List<Technology_plan> searchByTechnologyPlanIdOrName(String searchValue, int page, int rows, String flag);

    int searchByTechnologyPlanIdOrNameTotal(String searchValue, String flag);
}
