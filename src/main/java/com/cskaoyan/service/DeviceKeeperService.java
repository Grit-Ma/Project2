package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */
public interface DeviceKeeperService {

    Employee selectEmpById(String empId);

    List<Employee> selectAllEmp();

}
