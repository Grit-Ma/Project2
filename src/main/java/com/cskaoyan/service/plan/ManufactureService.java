package com.cskaoyan.service.plan;

import com.cskaoyan.bean.plan.Manufacture;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface ManufactureService {
    PageVo manufacturePage(int page, int rows) ;

    Manufacture manufactureGet(String id);

    List<Manufacture> manufactureGetData();

    ResponseVo updateManufacture(Manufacture manufacture);

    ResponseVo insertManufacture(Manufacture manufacture);

    @Delete("delete from ")
    ResponseVo batchDeleteManufactureByIds(List<String> ids);

    PageVo searchManufacturByManufactureSn(String searchValue, int page, int rows);

    PageVo searchManufacturByManufactureOrderId(String searchValue, int page, int rows);

    PageVo searchManufacturByManufactureTechnologyName(String searchValue, int page, int rows);
}
