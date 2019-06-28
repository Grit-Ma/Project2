package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> manufacturePage(int page, int rows) ;

    Manufacture manufactureGet(String id);

    ResponseVo updateManufacture(Manufacture manufacture);

    ResponseVo insertManufacture(Manufacture manufacture);

    ResponseVo batchDeleteManufactureByIds(List<String> ids);
}
