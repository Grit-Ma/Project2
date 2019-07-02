package com.cskaoyan.mapper.employee;

import com.cskaoyan.bean.employee.Department;
import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {


    List<Department> selectAll();  //返回所有部门

    Department findOne(@Param("id")int id);  //根据id返回相关部门数据

    void addDepartment(Department department);   //增加部门

    void delete_batch(String[] ids);  //选择删除

    void updateDepartment(Department department);  //编辑部门信息

    List<Department> selectById(String searchValue);  // 根据id迷糊查询

    List<Department> selectByName(String searchValue);  // 根据name迷糊查询

}