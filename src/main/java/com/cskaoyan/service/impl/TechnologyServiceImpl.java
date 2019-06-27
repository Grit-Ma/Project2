package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public List<Technology> queyTechnology(int page,int rows) {
       /* TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria();
        List<Technology> list = technologyMapper.selectByExample(technologyExample);*/

        int number = rows;
        int offset = (page - 1) * rows;
        List<Technology> list = technologyMapper.selectTecnologyByPageAndRows(number, offset);

        return list;
    }
}
