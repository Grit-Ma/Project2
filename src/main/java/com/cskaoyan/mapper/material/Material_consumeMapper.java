package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.Material_consume;
import com.cskaoyan.bean.material.Material_consumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Material_consumeMapper {
    long countByExample(Material_consumeExample example);

    int deleteByExample(Material_consumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(Material_consume record);

    int insertSelective(Material_consume record);

    List<Material_consume> selectByExample(Material_consumeExample example);

    Material_consume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") Material_consume record, @Param("example") Material_consumeExample example);

    int updateByExample(@Param("record") Material_consume record, @Param("example") Material_consumeExample example);

    int updateByPrimaryKeySelective(Material_consume record);

    int updateByPrimaryKey(Material_consume record);

    List<Material_consume> selectForMaterialAndMaterialConsumeAndWork();

    List<Material_consume> getMaterialConsumeByConsumeId(String searchValue);

    List<Material_consume> getMaterialConsumeByMaterialId(String searchValue);

    List<Material_consume> getMaterialConsumeByWorkId(String searchValue);
}