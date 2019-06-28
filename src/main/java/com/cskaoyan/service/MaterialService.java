package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface MaterialService {

    List<Material> getMaterial();

    List<Material> getMaterial_by_materialId(String searchValue);

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterial(Material material);

    ResponseVo insertMaterial(Material material);

    @Delete("delete from ")
    ResponseVo batchDeleteMaterialByIds(List<String> ids);

    ResponseVo updateMaterialNote(Material material);

    PageVo search_material_by_materialId(String searchValue, int page, int rows);
}
