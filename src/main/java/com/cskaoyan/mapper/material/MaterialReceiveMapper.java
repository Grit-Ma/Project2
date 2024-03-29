package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectForMaterialAndMaterialReceive();

    List<MaterialReceive> getMaterialReceiveByReceiveId(@Param("searchValue") String searchValue);

    List<MaterialReceive> getMaterialReceiveByMaterialId(@Param("searchValue") String searchValue);
}