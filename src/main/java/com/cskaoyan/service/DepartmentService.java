package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;

import java.util.List;

public interface DepartmentService {

    List<Department> selectAll();

    int countNum();

    Department findOne(int id);

    void addDepartment(Department department);

    void delete_batch(String[] ids);

    void updateEmployee(Department department);  //编辑部门信息


}
