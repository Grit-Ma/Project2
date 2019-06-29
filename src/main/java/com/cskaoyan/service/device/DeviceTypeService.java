package com.cskaoyan.service.device;

import com.cskaoyan.bean.Device_type;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */
public interface DeviceTypeService {

    Device_type selectTypeById(String typeId);

    List<Device_type> selectAllType();

    ResponseVo insertType(Device_type device_type);

    ResponseVo updateType(Device_type device_type);

    ResponseVo deleteType(List<String> ids);

    PageVo selectByTypeId(String searchValue, int page, int rows);

    PageVo selectByTypeName(String searchValue, int page, int rows);

    PageVo getPage(int page, int rows, List<Device_type> device_types);
}