package com.cskaoyan.service.material;

import com.cskaoyan.bean.Material_receive;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface MaterialReceiveService {

    List<Material_receive> getMaterialReceive();

    List<Material_receive> getMaterialReceiveByReceiveId(String searchValue);

    List<Material_receive> getMaterialReceiveByMaterialId(String searchValue);

    PageVo getPage(int page, int rows);

    ResponseVo updateMaterialReceive(Material_receive material_receive);

    ResponseVo insertMaterialReceive(Material_receive material_receive);

    @Delete("delete from ")
    ResponseVo batchDeleteMaterialReceiveByIds(List<String> ids);

    ResponseVo updateMaterialReceiveNote(Material_receive material_receive);

    PageVo searchMaterialReceiveByReceiveId(String searchValue, int page, int rows);

    PageVo searchMaterialReceiveByMaterialId(String searchValue, int page, int rows);
}
