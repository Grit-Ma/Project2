package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Technology_requirement;

import java.util.List;

public interface TechnologyRequirementService {
    List<Technology_requirement> queyTechnologyRequirement(int page, int rows);

    int queryTotalTechnologyRequirement();

    int insertTechnologyRequirement(Technology_requirement requirement);

    List<Technology_requirement> queyAllTechnologyRequirement();

    int updateTechnologyRequirement(Technology_requirement technologyRequirement);

    int deleteBatch(String[] ids);

    List<Technology_requirement> searchByTechnologyRequirementId(String s, int page, int rows, String flag);

    int searchByTechnologyRequirementIdTotal(String s, String flag);

    List<Technology_requirement> searchByTechnologyIdOrName(String searchValue, int page, int rows, String flag);

    int searchByTechnologyIdOrNameTotal(String searchValue, String flag);

    int update_requirement(String technologyRequirementId, String requirement);
}
