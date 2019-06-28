package com.cskaoyan.service.technologyService;

import com.cskaoyan.bean.Technology;

import java.util.List;

public interface TechnologyService {
    List<Technology> queyTechnology(int page, int rows);

    int queryTotalTechonlogyManage();

    int insertTechnology(Technology technology);

    int updateTechnology(Technology technology);

    List<Technology> queyAllTechnology();

    int deleteBatch(String[] ids);

    List<Technology> searchByTechnologyIdOrName(String searchValue, int page, int rows, String flag);

    int searchByTechnologyIdOrNameTotal(String searchValue, String flag);

    Technology queryTechnologyById(String technologyId);
}
