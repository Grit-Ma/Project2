package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {
    List<TechnologyRequirement> queyTechnologyRequirement(int page, int rows);

    int queryTotalTechnologyRequirement();

    int insertTechnologyRequirement(TechnologyRequirement requirement);

    List<TechnologyRequirement> queyAllTechnologyRequirement();

    int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    int deleteBatch(String[] ids);

    List<TechnologyRequirement> searchByTechnologyRequirementId(String s, int page, int rows, String flag);

    int searchByTechnologyRequirementIdTotal(String s, String flag);

    List<TechnologyRequirement> searchByTechnologyIdOrName(String searchValue, int page, int rows, String flag);

    int searchByTechnologyIdOrNameTotal(String searchValue, String flag);

    int update_requirement(String technologyRequirementId, String requirement);
}
