package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {

    int getAllCount();

    List<Material> getMaterial();
}