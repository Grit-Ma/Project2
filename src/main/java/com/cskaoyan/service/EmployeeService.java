package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> selectAll();

    int countNum();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void delete_batch(String[] ids);
}
