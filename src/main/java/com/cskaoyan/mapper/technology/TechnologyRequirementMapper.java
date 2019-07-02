package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.bean.technology.TechnologyRequirementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> queyTechnologyRequirement(@Param("number") int number, @Param("offset") int offset);

    int queryTotalTechnologyRequirement();

    List<TechnologyRequirement> queryTechnologyRequirementAll();

    int deleteBatch(@Param("ids") String[] ids);

    List<TechnologyRequirement> searchByTechnologyRequirementIdOrName(@Param("search") String search, @Param("number") int number, @Param("offset") int offset, @Param("flag") String flag);

    int searchByTechnologyRequirementTotal(@Param("search") String search, @Param("flag") String flag);

    int updateRequirementById(@Param("technologyRequirementId") String technologyRequirementId, @Param("requirement") String requirement);
}