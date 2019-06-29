package com.cskaoyan.service.device;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DevicePlus;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/26
 */
public interface DeviceService {

    List<Device> selectAllDevice();

    PageVo getPage(int page, int rows, List<DevicePlus> devicePluses);

    ResponseVo insertDevice(DevicePlus devicePlus);

    ResponseVo updateDevice(DevicePlus devicePlus);

    ResponseVo deleteDevice(List<String> ids);

    PageVo selectById(String searchValue,int page, int rows);

    PageVo selectByName(String searchValue,int page, int rows);

    PageVo selectByTypeName(String searchValue,int page, int rows);

    Device selectDeviceById(String Id);

    ResponseVo updateNote(Device device);
}
