package com.cskaoyan.service.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/29
 */
public interface DeviceFaultService {

    PageVo getPage(int page, int rows, List<DeviceFault> device_faults);

    List<DeviceFault> selectAllFault();

    ResponseVo insertFault(DeviceFault device_fault);

    ResponseVo updateFault(DeviceFault device_fault);

    ResponseVo deleteFault(List<String> ids);

    PageVo selectByName(String searchValue, int page, int rows);

    PageVo selectByFaultId(String searchValue, int page, int rows);

    DeviceFault selectById(String faultId);

    ResponseVo updateNote(DeviceFault device_fault);
}
