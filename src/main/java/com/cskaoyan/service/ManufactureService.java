package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> manufacturePage(int page, int rows) ;

    Manufacture manufactureGet(String id);

<<<<<<< HEAD
    List<Manufacture> manufactureGetData();
=======
    ResponseVo updateManufacture(Manufacture manufacture);

    ResponseVo insertManufacture(Manufacture manufacture);

    ResponseVo batchDeleteManufactureByIds(List<String> ids);
>>>>>>> 3de0c9461739f158f94aee34fa3eeae93b9f314b
}
