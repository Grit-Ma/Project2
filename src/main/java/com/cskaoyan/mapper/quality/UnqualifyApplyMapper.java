package com.cskaoyan.mapper.quality;

import com.cskaoyan.bean.quality.UnqualifyApply;
import com.cskaoyan.bean.quality.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {

    //查询出所有的不合格品
    List<UnqualifyApply> selectAll();

    //根据名字模糊查询
    List<UnqualifyApply> fuzzyqueryByPname(@Param("pname") String pname);

    //根据id模糊查询
    List<UnqualifyApply> fuzzyqueryByPid(@Param("pid") String pid);

    int countAll();

    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
}