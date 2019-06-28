package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;



    //返回所有员工的列表
    public List<Employee> selectAll(){
        return employeeMapper.selectAll();
    }

    //求员工总数
    public int countNum(){
        return employeeMapper.countNum();
    }

    //增加一个员工
    public void addEmployee(Employee employee){

        employeeMapper.addEmployee(employee);

    }

    //编辑员工
    @Override
    public void updateEmployee(Employee employee) {

        employeeMapper.updateEmployee(employee);

    }

    //删除员工
    @Override
    public void delete_batch(String[] ids) {

        employeeMapper.delete_batch(ids);

    }
}
