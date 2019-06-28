package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.impl.DepartmentServiceImp;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentServiceImp departmentServiceImp;

    //从home右侧点击进入部门管理
    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/department_list.jsp";
    }

    //返回部门列表的json数据
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(int page, int rows){
        //查找全部员工,及员工总数
        List<Department> departmentList = departmentServiceImp.selectAll();
        int count = departmentServiceImp.countNum();
        //封装当前页面显示数据
        List<Department> pageList = PageTool.getPagedData(departmentList,page,rows);
        //封装map返回
        Map<String,Object> result = new HashMap();
        result.put("rows",pageList);
        result.put("total",count);
        return result;
    }



    //员工列表回显员工的部门信息
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Department department(@PathVariable int id){
        Department department = departmentServiceImp.findOne(id);
        return department;
    }
    //新增员工下拉框回显部门信息
    @RequestMapping("get_data")
    @ResponseBody
    public List departmentList(){
        List<Department> departmentList = departmentServiceImp.selectAll();
        return departmentList;
    }



    //判断
    @RequestMapping("*_judge")
    @ResponseBody
    public String addJudge(){
        System.out.println("judge");
        return "";
    }



    //进入新增部门页面
    @RequestMapping("add")
    public String addJsp(){
        System.out.println("add");
        return "/WEB-INF/jsp/department_add.jsp";
    }
    //新增部门请求，返回所填信息
    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo add(String departmentId, String departmentName, String note){
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setNote(note);

        departmentServiceImp.addDepartment(department);

        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");

        return result;
    }



    //删除部门
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        departmentServiceImp.delete_batch(ids);
        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");
        return result;
    }


    //编辑员工界面
    @RequestMapping("edit")
    public String editUrl(){
        return "/WEB-INF/jsp/department_edit.jsp";
    }
    //编辑员工，获取员工信息，update数据库
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo edit(Department department){
        departmentServiceImp.updateEmployee(department);
        //封装返回值
        ResponseVo result = new ResponseVo(200,"ok","");
        return result;
    }
}
