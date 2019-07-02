package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceMaintainService {

    PageVo getPage(int page, int rows, List<DeviceMaintain> device_maintains);

    List<DeviceMaintain> selectAllMaintain();

    ResponseVo insertMaintain(DeviceMaintain device_maintain);

    ResponseVo updateMaintain(DeviceMaintain device_maintain);

    ResponseVo deleteMaintain(List<String> ids);

    PageVo selectByFaultId(String searchValue, int page, int rows);

    PageVo selectByMaintianId(String searchValue, int page, int rows);

    ResponseVo updateNote(DeviceMaintain device_maintain);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);
}
