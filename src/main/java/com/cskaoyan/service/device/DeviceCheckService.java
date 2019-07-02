package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceCheckService {

    PageVo getPage(int page, int rows, List<DeviceCheck> device_checks);

    List<DeviceCheck> selectAllCheck();

    ResponseVo insertCheck(DeviceCheck device_check);

    ResponseVo updateCheck(DeviceCheck device_check);

    ResponseVo deleteCheck(List<String> ids);

    PageVo selectByCheckId(String searchValue,int page, int rows);

    PageVo selectByName(String searchValue,int page, int rows);

    ResponseVo updateNote(DeviceCheck device_check);


}
