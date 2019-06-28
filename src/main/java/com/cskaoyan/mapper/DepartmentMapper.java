package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {


    List<Department> selectAll();

    int countNum();  //求部门总数

    Department findOne(@Param("id")int id);  //根据id返回相关部门数据

    void addDepartment(Department department);   //增加部门

    void delete_batch(String[] ids);  //选择删除

    void updateDepartment(Department department);  //编辑部门信息

}