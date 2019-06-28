package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.DepartmentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;


    //返回所有部门的列表
    public List<Department> selectAll(){
        return departmentMapper.selectAll();
    }



    //根据id查询部门信息
    public Department findOne(int id){
        return departmentMapper.findOne(id);
    }

    //增加部门
    public void addDepartment(Department department){
        departmentMapper.addDepartment(department);

    }

    //删除部门
    @Override
    public void delete_batch(String[] ids) {
        departmentMapper.delete_batch(ids);

    }


    //编辑部门
    @Override
    public void updateEmployee(Department department) {
        departmentMapper.updateDepartment(department);

    }


    //根据编号模糊查询部门
    @Override
    public List<Department> selectById(String searchValue) {
        List<Department> departmentList = departmentMapper.selectById(searchValue);
        return departmentList;
    }
    //根据名称模糊查询部门
    @Override
    public List<Department> selectByName(String searchValue) {
        List<Department> departmentList = departmentMapper.selectByName(searchValue);
        return departmentList;
    }

}
