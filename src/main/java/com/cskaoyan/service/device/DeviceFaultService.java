package com.cskaoyan.service.device;

import com.cskaoyan.bean.Device_fault;
import com.cskaoyan.vo.PageVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceFaultService {

    PageVo getPage(int page, int rows, List<Device_fault> device_faults);

    List<Device_fault> selectAllFault();
}
