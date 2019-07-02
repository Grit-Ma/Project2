package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.employee.Employee;
import com.cskaoyan.mapper.employee.EmployeeMapper;
import com.cskaoyan.service.device.DeviceKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Employee> selectAllEmp() {
        return employeeMapper.selectAll();
    }
}
