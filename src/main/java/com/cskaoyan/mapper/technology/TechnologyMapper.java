package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectTecnologyByPageAndRows(@Param("number") int number, @Param("offset") int offset);

    int queryTotalTechonlogyManage();

    int insertTechnology(Technology technology);

    int deleteBatch(@Param("ids") String[] ids);

    List<Technology> searchByTechnologyIdOrName(
            @Param("search") String search, @Param("number") int number, @Param("offset") int offset, @Param("flag") String flag);

    int searchByTechnologyIdOrNameTotal(@Param("search") String search, @Param("flag") String flag);
}