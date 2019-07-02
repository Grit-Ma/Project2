package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */
public interface DeviceTypeService {

    DeviceType selectTypeById(String typeId);

    List<DeviceType> selectAllType();

    ResponseVo insertType(DeviceType device_type);

    ResponseVo updateType(DeviceType device_type);

    ResponseVo deleteType(List<String> ids);

    PageVo selectByTypeId(String searchValue, int page, int rows);

    PageVo selectByTypeName(String searchValue, int page, int rows);

    PageVo getPage(int page, int rows, List<DeviceType> device_types);
}