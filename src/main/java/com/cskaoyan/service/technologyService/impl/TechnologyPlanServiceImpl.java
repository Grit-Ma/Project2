package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Technology_plan;
import com.cskaoyan.bean.Technology_planExample;
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
        List<Technology_plan> list = planMapper.selectTechnologyPlanByPageAndRows(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechnologyPlan() {
        int total = planMapper.queryTotalTechnologyPlan();
        return total;
    }

    @Override
    public int insertTechnologyPlan(Technology_plan technologyPlan) {
        int insert = planMapper.insert(technologyPlan);
        return insert;
    }

    @Override
    public int updateTechnologyPlan(Technology_plan technologyPlan) {
        int i = planMapper.updateByPrimaryKey(technologyPlan);
        return i;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int i = planMapper.deleteBatch(ids);
        return i;
    }

    @Override
    public List<Technology_plan> queryAllTechnologyPlan() {
        Technology_planExample example = new Technology_planExample();
        List<Technology_plan> technology_plans = planMapper.selectByExample(example);
        return technology_plans;
    }

    @Override
    public Technology_plan queryTechnologyPlanById(String technologyPlanId) {
        Technology_plan technologyPlan = planMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public List<Technology_plan> searchByTechnologyPlanId(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<Technology_plan> list = planMapper.searchByTechnologyPlanIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyPlanIdTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = planMapper.searchByTechnologyPlanTotal(search,flag);
        return total;
    }

    @Override
    public List<Technology_plan> searchByTechnologyPlanIdOrName(String searchValue, int page, int rows, String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<Technology_plan> list = planMapper.searchByTechnologyPlanIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyPlanIdOrNameTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = planMapper.searchByTechnologyPlanTotal(search,flag);
        return total;
    }

}
