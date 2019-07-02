package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

public interface MaterialConsumeService {

    List<MaterialConsume> getMaterialConsume();

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterialConsume(MaterialConsume material_consume);

    ResponseVo updateMaterialConsumeNote(MaterialConsume material_consume);

    ResponseVo insertMaterialConsume(MaterialConsume material_consume);

    ResponseVo batchDeleteMaterialConsumeByIds(List<String> ids);

    PageVo searchMaterialConsumeByConsumeId(String searchValue, int page, int rows);

    PageVo searchMaterialConsumeByMaterialId(String searchValue, int page, int rows);

    PageVo searchMaterialConsumeByWorkId(String searchValue, int page, int rows);
}
