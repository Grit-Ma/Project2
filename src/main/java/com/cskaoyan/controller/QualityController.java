package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;

import com.cskaoyan.bean.Unqualify_apply;
import com.cskaoyan.bean.Unqualify_applyExample;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.service.Unqualify_applyService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class QualityController {
    @Autowired
    Unqualify_applyService unqualify_applyService;
    @Autowired
    DepartmentService departmentService;


    @RequestMapping("unqualify/find")
    public String findAllUnqualify(HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        arrayList.add("unqualify:add");
        arrayList.add("unqualify:edit");
        arrayList.add("unqualify:delete");
        session.setAttribute("sysPermissionList",arrayList);
        return ("/WEB-INF/jsp/unqualify_list.jsp");
    }


    @RequestMapping("unqualify/list")
    @ResponseBody
    public PageVo checkUnqualify(@RequestParam("page")int page, @RequestParam("rows")int rows){
        List<Unqualify_apply> unqualify_applies = unqualify_applyService.selectAll();
        PageVo pageVo = PageTool.getPageVo(unqualify_applies, page, rows);
        return pageVo;
    }

    @RequestMapping("department/get_data")
    @ResponseBody
    public List<Department> getData(){
        List<Department> departments = departmentService.queryAllDepartments();
        System.out.println(departments);
        return departments;
    }

    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public void deleteUnqualify_Judge(){

    }

    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(@RequestParam("ids")String ids){
        ResponseVo responseVo = new ResponseVo();
        Unqualify_applyExample unqualify_applyExample = new Unqualify_applyExample();
        Unqualify_applyExample.Criteria criteria = unqualify_applyExample.createCriteria();
        ArrayList<String> list = new ArrayList<>();
        list.add(ids);
        criteria.andUnqualifyApplyIdIn(list);
        int i = unqualify_applyService.deleteByExample(unqualify_applyExample);
        if(i==1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public void addJudge(){

    }


    @RequestMapping("unqualify/add")
    public String addUnqualify(){
        return ("/WEB-INF/jsp/unqualify_add.jsp");
    }


    @RequestMapping("unqualify/insert")
    public ResponseVo insertUnqualify(Unqualify_apply unqualify_apply){
        ResponseVo responseVo = new ResponseVo();
        int i = unqualify_applyService.insert(unqualify_apply);
        if(i==1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }


    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public void editJudge(){

    }

    @RequestMapping("unqualify/edit")
    public String editUnqualify(){
        return ("/WEB-INF/jsp/unqualify_add.jsp");
    }

    @RequestMapping("unqualify/update_all")
    public ResponseVo updateUnqualify(Unqualify_apply unqualify_apply){
        ResponseVo responseVo = new ResponseVo();
        int i = unqualify_applyService.updateByPrimaryKey(unqualify_apply);
        if(i==1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
}
