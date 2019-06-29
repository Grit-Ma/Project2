package com.cskaoyan.service.device;

import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.bean.Device_maintain;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceMaintainService {

    PageVo getPage(int page, int rows, List<Device_maintain> device_maintains);

    List<Device_maintain> selectAllMaintain();

    ResponseVo insertMaintain(Device_maintain device_maintain);

    ResponseVo updateMaintain(Device_maintain device_maintain);

    ResponseVo deleteMaintain(List<String> ids);

    PageVo selectByFaultId(String searchValue, int page, int rows);

    PageVo selectByMaintianId(String searchValue, int page, int rows);
}
