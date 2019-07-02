package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface MaterialReceiveService {

    List<MaterialReceive> getMaterialReceive();

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterialReceive(MaterialReceive material_receive);

    ResponseVo insertMaterialReceive(MaterialReceive material_receive);

    @Delete("delete from ")
    ResponseVo batchDeleteMaterialReceiveByIds(List<String> ids);

    ResponseVo updateMaterialReceiveNote(MaterialReceive material_receive);

    PageVo searchMaterialReceiveByReceiveId(String searchValue, int page, int rows);

    PageVo searchMaterialReceiveByMaterialId(String searchValue, int page, int rows);
}
