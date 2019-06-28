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

    Employee selectByPrimaryKey(String empId);  //根据编号返回一 个员工

    List<Employee> selectById(String searchValue);  //模糊查询根据员工编号

    List<Employee> selectByName(String searchValue);  //模糊查询根据员工名称

    List<Employee> selectByDepartmentName(String searchValue);   //模糊查询根据部门名称

}