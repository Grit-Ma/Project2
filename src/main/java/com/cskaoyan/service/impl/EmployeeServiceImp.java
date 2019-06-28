package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImp implements EmployeeService {
    SqlSession sqlSession;
    @Autowired
    SqlSessionFactory sqlSessionFactory;



    //返回所有员工的列表
    public List<Employee> selectAll(){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(EmployeeMapper.class).selectAll();
    }

    //求员工总数
    public int countNum(){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(EmployeeMapper.class).countNum();
    }

    //增加一个员工
    public void addEmployee(Employee employee){
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(EmployeeMapper.class).addEmployee(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    //编辑员工
    @Override
    public void updateEmployee(Employee employee) {
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(EmployeeMapper.class).updateEmployee(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    //删除员工
    @Override
    public void delete_batch(String[] ids) {
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(EmployeeMapper.class).delete_batch(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
