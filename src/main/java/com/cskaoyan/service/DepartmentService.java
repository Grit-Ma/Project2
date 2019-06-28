package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;

import java.util.List;

public interface DepartmentService {

    List<Department> selectAll();    //返回所有部门

    Department findOne(int id);   //根据id返回一个部门

    void addDepartment(Department department);   //添加一个部门

    void delete_batch(String[] ids);   //删除所选部门

    void updateEmployee(Department department);  //编辑部门信息

    List<Department> selectById(String searchValue);  //模糊查询根据编号

    List<Department> selectByName(String searchValue);  //模糊查询根据名称



}
