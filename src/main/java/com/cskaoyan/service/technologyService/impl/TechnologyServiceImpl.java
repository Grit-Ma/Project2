package com.cskaoyan.service.technologyService.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyExample;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public List<Technology> queyTechnology(int page,int rows) {
        int number = rows;
        int offset = (page - 1) * rows;
        List<Technology> list = technologyMapper.selectTecnologyByPageAndRows(number, offset);
        return list;
    }

    @Override
    public int queryTotalTechonlogyManage() {
        int total = technologyMapper.queryTotalTechonlogyManage();
        return total;
    }

    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insertTechnology(technology);
        return insert;
    }

    @Override
    public int updateTechnology(Technology technology) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria().andTechnologyIdEqualTo(technology.getTechnologyId());
        int i = technologyMapper.updateByExample(technology, technologyExample);
        return i;
    }

    @Override
    public List<Technology> queyAllTechnology() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> list = technologyMapper.selectByExample(technologyExample);
        return list;
    }

    @Override
    public int deleteBatch(String[] ids) {
        int i = technologyMapper.deleteBatch(ids);
        return i;
    }

    @Override
    public List<Technology> searchByTechnologyIdOrName(String searchValue, int page, int rows,String flag) {
        int number = rows;
        int offset = (page - 1) * rows;
        String search = "%" + searchValue + "%";
        List<Technology> list = technologyMapper.searchByTechnologyIdOrName(search,number,offset,flag);
        return list;
    }

    @Override
    public int searchByTechnologyIdOrNameTotal(String searchValue, String flag) {
        String search  = "%" + searchValue + "%";
        int total = technologyMapper.searchByTechnologyIdOrNameTotal(search,flag);
        return total;
    }

    @Override
    public Technology queryTechnologyById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

    @Override
    public Technology queryTechnologyPlanById(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }

}
