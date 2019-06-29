package com.cskaoyan.service.device;

import com.cskaoyan.bean.Device_check;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceCheckService {

    PageVo getPage(int page, int rows, List<Device_check> device_checks);

    List<Device_check> selectAllCheck();

    ResponseVo insertCheck(Device_check device_check);

    ResponseVo updateCheck(Device_check device_check);

    ResponseVo deleteCheck(List<String> ids);

    PageVo selectByCheckId(String searchValue,int page, int rows);

    PageVo selectByName(String searchValue,int page, int rows);

    ResponseVo updateNote(Device_check device_check);


}
