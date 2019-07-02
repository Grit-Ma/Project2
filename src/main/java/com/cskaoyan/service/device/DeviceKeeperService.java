package com.cskaoyan.service.device;

import com.cskaoyan.bean.employee.Employee;

import java.util.List;

/**
 * created by ZengWei
 * on 2019/6/27
 */
public interface DeviceKeeperService {

    Employee selectEmpById(String empId);

    List<Employee> selectAllEmp();

}
