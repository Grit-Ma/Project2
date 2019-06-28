package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface MaterialService {

    List<Material> getMaterial();

    List<Material> getMaterialByMaterialId(String searchValue);

    List<Material> getMaterialByMaterialType(String searchValue);

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterial(Material material);

    ResponseVo insertMaterial(Material material);

    @Delete("delete from ")
    ResponseVo batchDeleteMaterialByIds(List<String> ids);

    ResponseVo updateMaterialNote(Material material);

    PageVo searchMaterialByMaterialId(String searchValue, int page, int rows);

    PageVo searchMaterialByMaterialType(String searchValue, int page, int rows);

    Material getAMaterialByMaterialId(String id);
}
