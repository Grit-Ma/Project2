package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    List<Employee> selectAll();  //获取所有员工

    int countNum();  //计算员工总数

    void addEmployee(Employee employee);  //z增加一个员工

    void updateEmployee(Employee employee);  //编辑员工信息

    void delete_batch(String[] ids);  //选择删除

    Employee selectByPrimaryKey(String empId);

}