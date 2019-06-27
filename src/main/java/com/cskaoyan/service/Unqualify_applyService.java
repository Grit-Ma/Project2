package com.cskaoyan.service;

import com.cskaoyan.bean.Unqualify_apply;
import com.cskaoyan.bean.Unqualify_applyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Unqualify_applyService {

    List<Unqualify_apply> selectAll();

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
