package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Technology_requirement;

import java.util.List;

public interface TechnologyRequirementService {
    List<Technology_requirement> queyTechnologyRequirement(int page, int rows);

    int queryTotalTechnologyRequirement();

    int insertTechnologyRequirement(Technology_requirement requirement);

    List<Technology_requirement> queyAllTechnologyRequirement();
}
