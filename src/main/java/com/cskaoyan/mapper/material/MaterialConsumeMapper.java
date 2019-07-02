package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialConsumeMapper {
    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> selectForMaterialAndMaterialConsumeAndWork();

    List<MaterialConsume> getMaterialConsumeByConsumeId(String searchValue);

    List<MaterialConsume> getMaterialConsumeByMaterialId(String searchValue);

    List<MaterialConsume> getMaterialConsumeByWorkId(String searchValue);
}