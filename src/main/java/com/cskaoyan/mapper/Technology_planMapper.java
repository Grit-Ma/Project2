package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology_plan;
import com.cskaoyan.bean.Technology_planExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Technology_planMapper {
    long countByExample(Technology_planExample example);

    int deleteByExample(Technology_planExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(Technology_plan record);

    int insertSelective(Technology_plan record);

    List<Technology_plan> selectByExample(Technology_planExample example);

    Technology_plan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") Technology_plan record, @Param("example") Technology_planExample example);

    int updateByExample(@Param("record") Technology_plan record, @Param("example") Technology_planExample example);

    int updateByPrimaryKeySelective(Technology_plan record);

    int updateByPrimaryKey(Technology_plan record);

    List<Technology_plan> selectTechnologyPlanByPageAndRows(@Param("number") int number, @Param("offset") int offset);

    int queryTotalTechnologyPlan();

    int deleteBatch(@Param("ids") String[] ids);

    List<Technology_plan> searchByTechnologyPlanIdOrName(@Param("search") String search, @Param("number") int number, @Param("offset") int offset, @Param("flag") String flag);

    int searchByTechnologyPlanTotal(@Param("search") String search, @Param("flag") String flag);
}