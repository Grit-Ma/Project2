package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectTechnologyPlanByPageAndRows(@Param("number") int number, @Param("offset") int offset);

    int queryTotalTechnologyPlan();

    int deleteBatch(@Param("ids") String[] ids);

    List<TechnologyPlan> searchByTechnologyPlanIdOrName(@Param("search") String search, @Param("number") int number, @Param("offset") int offset, @Param("flag") String flag);

    int searchByTechnologyPlanTotal(@Param("search") String search, @Param("flag") String flag);
}