package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.DeviceKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by ZengWei
 * on 2019/6/27
 */

@Service
public class DeviceKeeperImpl implements DeviceKeeperService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee selectEmpById(String empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }
}
