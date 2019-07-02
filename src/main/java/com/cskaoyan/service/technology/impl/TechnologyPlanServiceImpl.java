package com.cskaoyan.service.technology.impl;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyPlanExample;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import com.cskaoyan.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper planMapper;
    @Override
    public List<TechnologyPlan> queyTechonlogyPlan(int page, int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<TechnologyPlan> list = planMapper.selectTechnologyPlanByPageAndRows(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechnologyPlan() {
        int total = planMapper.queryTotalTechnologyPlan();
        return total;
    }

    @Override
    public int insertTechnologyPlan(TechnologyPlan technologyPlan) {
        int insert = planMapper.insert(technologyPlan);
        return insert;
    }

    @Override
    public int updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int i = planMapper.updateByPrimaryKey(technologyPlan);
        return i;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int i = planMapper.deleteBatch(ids);
        return i;
    }

    @Override
    public List<TechnologyPlan> queryAllTechnologyPlan() {
        TechnologyPlanExample example = new TechnologyPlanExample();
        List<TechnologyPlan> technology_plans = planMapper.selectByExample(example);
        return technology_plans;
    }

    @Override
    public TechnologyPlan queryTechnologyPlanById(String technologyPlanId) {
        TechnologyPlan technologyPlan = planMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public List<TechnologyPlan> searchByTechnologyPlanId(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<TechnologyPlan> list = planMapper.searchByTechnologyPlanIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyPlanIdTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = planMapper.searchByTechnologyPlanTotal(search,flag);
        return total;
    }

    @Override
    public List<TechnologyPlan> searchByTechnologyPlanIdOrName(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<TechnologyPlan> list = planMapper.searchByTechnologyPlanIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyPlanIdOrNameTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = planMapper.searchByTechnologyPlanTotal(search,flag);
        return total;
    }

}
