package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {
    List<TechnologyPlan> queyTechonlogyPlan(int page, int rows);

    int queryTotalTechnologyPlan();

    int insertTechnologyPlan(TechnologyPlan technologyPlan);

    int updateTechnologyPlan(TechnologyPlan technologyPlan);

    int deleteBatch(String[] ids);

    List<TechnologyPlan> queryAllTechnologyPlan();

    TechnologyPlan queryTechnologyPlanById(String technologyPlanId);

    List<TechnologyPlan> searchByTechnologyPlanId(String searchValue, int page, int rows, String flag);

    int searchByTechnologyPlanIdTotal(String searchValue, String flag);

    List<TechnologyPlan> searchByTechnologyPlanIdOrName(String searchValue, int page, int rows, String flag);

    int searchByTechnologyPlanIdOrNameTotal(String searchValue, String flag);
}
