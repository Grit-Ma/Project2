package com.cskaoyan.controller;


import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.service.impl.DepartmentServiceImp;
import com.cskaoyan.service.impl.EmployeeServiceImp;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImp employeeService;



    //从home右侧点击进入员工管理
    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/employee_list.jsp";
    }

    //返回员工列表的json数据，是map格式
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(int page, int rows){
        //查找全部员工,及员工总数
        List<Employee> employeeList = employeeService.selectAll();
        int count = employeeService.countNum();
        //封装当前页面显示数据
        List<Employee> pageList = PageTool.getPagedData(employeeList,page,rows);
        //封装map返回
        Map<String,Object> result = new HashMap();
        result.put("rows",pageList);
        result.put("total",count);
        return result;
    }




    //判断
    @RequestMapping("*_judge")
    @ResponseBody
    public String addJudge(){
        System.out.println("judge");
        return "";
    }




    //进入新增员工的页面
    @RequestMapping("add")
    public String addUrl(){
        return "/WEB-INF/jsp/employee_add.jsp";
    }
    //新增员工请求，返回所填信息
    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo add(Employee employee){
        employeeService.addEmployee(employee);
        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");
        return result;
    }




    //编辑员工界面
    @RequestMapping("edit")
    public String editUrl(){
        return "/WEB-INF/jsp/employee_edit.jsp";
    }
    //编辑员工，获取员工信息，update数据库
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo edit(Employee employee){
        employeeService.updateEmployee(employee);
        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");
        return result;
    }



    //删除员工
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        employeeService.delete_batch(ids);
        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");
        return result;
    }
}
