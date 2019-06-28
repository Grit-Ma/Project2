package com.cskaoyan.service.impl;

import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;


    //返回所有部门的列表
    public List<Department> selectAll(){
        return departmentMapper.selectAll();
    }


    //求部门总数
    public int countNum(){
        return departmentMapper.countNum();
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

}
