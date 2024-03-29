package com.cskaoyan.mapper.plan;

import com.cskaoyan.bean.plan.Manufacture;
import com.cskaoyan.bean.plan.ManufactureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> getManufacturByManufactureSn(String searchValue);

    List<Manufacture> getManufacturByOrderId(String searchValue);

    List<Manufacture> searchManufacturTechnologyName(String searchValue);

    List<Manufacture> selectForManufactureAndCorderAndTechnology();
}