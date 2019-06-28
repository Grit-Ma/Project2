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
public class DepartmentServiceImp implements DepartmentService {

    SqlSession sqlSession;
    @Autowired
    SqlSessionFactory sqlSessionFactory;



    //返回所有部门的列表
    public List<Department> selectAll(){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(DepartmentMapper.class).selectAll();
    }


    //求部门总数
    public int countNum(){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(DepartmentMapper.class).countNum();
    }

    //根据id查询部门信息
    public Department findOne(int id){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(DepartmentMapper.class).findOne(id);
    }

    //增加部门
    public void addDepartment(Department department){
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(DepartmentMapper.class).addDepartment(department);
        sqlSession.commit();
        sqlSession.close();
    }

    //删除部门
    @Override
    public void delete_batch(String[] ids) {
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(DepartmentMapper.class).delete_batch(ids);
        sqlSession.commit();
        sqlSession.close();
    }


    //编辑部门
    @Override
    public void updateEmployee(Department department) {
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(DepartmentMapper.class).updateDepartment(department);
        sqlSession.commit();
        sqlSession.close();
    }

}
