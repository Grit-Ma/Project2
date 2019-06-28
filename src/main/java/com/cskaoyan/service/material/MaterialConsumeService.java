package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material_consume;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

public interface MaterialConsumeService {

    List<Material_consume> getMaterialConsume();

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterialConsume(Material_consume material_consume);

    ResponseVo updateMaterialConsumeNote(Material_consume material_consume);

    ResponseVo insertMaterialConsume(Material_consume material_consume);

    ResponseVo batchDeleteMaterialConsumeByIds(List<String> ids);

    PageVo searchMaterialConsumeByConsumeId(String searchValue, int page, int rows);

    PageVo searchMaterialConsumeByMaterialId(String searchValue, int page, int rows);

    PageVo searchMaterialConsumeByWorkId(String searchValue, int page, int rows);
}
