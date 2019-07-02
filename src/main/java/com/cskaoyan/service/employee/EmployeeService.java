package com.cskaoyan.service.employee;

import com.cskaoyan.bean.employee.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> selectAll();

    int countNum();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void delete_batch(String[] ids);

    List<Employee> selectById(String searchValue);  //模糊查询根据员工编号

    List<Employee> selectByName(String searchValue);  //模糊查询根据员工名称

    List<Employee> selectByDepartmentName(String searchValue);   //模糊查询根据部门名称
}
