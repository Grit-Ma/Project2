package com.cskaoyan.service.technology.impl;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.mapper.technology.TechnologyRequirementMapper;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper requirementMapper;

    @Override
    public int insertTechnologyRequirement(TechnologyRequirement requirement) {
        int insert = requirementMapper.insert(requirement);
        return insert;
    }

    @Override
    public List<TechnologyRequirement> queyAllTechnologyRequirement() {
        List<TechnologyRequirement> list = requirementMapper.queryTechnologyRequirementAll();
        return list;
    }

    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int i = requirementMapper.updateByPrimaryKey(technologyRequirement);
        return i;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int i = requirementMapper.deleteBatch(ids);
        return i;
    }

    @Override
    public List<TechnologyRequirement> searchByTechnologyRequirementId(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<TechnologyRequirement> list = requirementMapper.searchByTechnologyRequirementIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyRequirementIdTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = requirementMapper.searchByTechnologyRequirementTotal(search,flag);
        return total;
    }

    @Override
    public List<TechnologyRequirement> searchByTechnologyIdOrName(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<TechnologyRequirement> list = requirementMapper.searchByTechnologyRequirementIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyIdOrNameTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = requirementMapper.searchByTechnologyRequirementTotal(search,flag);
        return total;
    }

    @Override
    public int update_requirement(String technologyRequirementId, String requirement) {
        int i = requirementMapper.updateRequirementById(technologyRequirementId,requirement);
        return i;
    }

    @Override
    public List<TechnologyRequirement> queyTechnologyRequirement(int page, int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<TechnologyRequirement> list = requirementMapper.queyTechnologyRequirement(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechnologyRequirement() {
        int total = requirementMapper.queryTotalTechnologyRequirement();
        return total;
    }
}
