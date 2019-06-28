package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Technology_requirement;
import com.cskaoyan.mapper.Technology_requirementMapper;
import com.cskaoyan.service.technologyService.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    Technology_requirementMapper requirementMapper;

    @Override
    public int insertTechnologyRequirement(Technology_requirement requirement) {
        int insert = requirementMapper.insert(requirement);
        return insert;
    }

    @Override
    public List<Technology_requirement> queyAllTechnologyRequirement() {
        List<Technology_requirement> list = requirementMapper.queryTechnologyRequirementAll();
        return list;
    }

    @Override
    public List<Technology_requirement> queyTechnologyRequirement(int page, int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<Technology_requirement> list = requirementMapper.queyTechnologyRequirement(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechnologyRequirement() {
        int total = requirementMapper.queryTotalTechnologyRequirement();
        return total;
    }
}
