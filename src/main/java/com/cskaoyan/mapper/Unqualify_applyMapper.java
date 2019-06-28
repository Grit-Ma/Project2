package com.cskaoyan.mapper;

import com.cskaoyan.bean.Unqualify_apply;
import com.cskaoyan.bean.Unqualify_applyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Unqualify_applyMapper {

    //查询出所有的不合格品
    List<Unqualify_apply> selectAll();

    //根据名字模糊查询
    List<Unqualify_apply> fuzzyquery(@Param("pname") String pname);

    int countAll();

    long countByExample(Unqualify_applyExample example);

    int deleteByExample(Unqualify_applyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(Unqualify_apply record);

    int insertSelective(Unqualify_apply record);

    List<Unqualify_apply> selectByExample(Unqualify_applyExample example);

    Unqualify_apply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") Unqualify_apply record, @Param("example") Unqualify_applyExample example);

    int updateByExample(@Param("record") Unqualify_apply record, @Param("example") Unqualify_applyExample example);

    int updateByPrimaryKeySelective(Unqualify_apply record);

    int updateByPrimaryKey(Unqualify_apply record);
}