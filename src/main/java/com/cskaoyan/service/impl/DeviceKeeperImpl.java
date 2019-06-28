package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeExample;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.DeviceKeeperService;
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
        return employeeMapper.selectByExample(new EmployeeExample());
    }
}
