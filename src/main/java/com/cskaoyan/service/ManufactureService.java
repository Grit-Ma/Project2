package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> manufacturePage(int page, int rows) ;

    Manufacture manufactureGet(String id);

    List<Manufacture> manufactureGetData();

    ResponseVo updateManufacture(Manufacture manufacture);

    ResponseVo insertManufacture(Manufacture manufacture);

    @Delete("delete from ")
    ResponseVo batchDeleteManufactureByIds(List<String> ids);
}
