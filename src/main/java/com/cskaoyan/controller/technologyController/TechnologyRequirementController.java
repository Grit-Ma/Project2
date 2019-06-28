package com.cskaoyan.controller.technologyController;

import com.cskaoyan.bean.Technology_requirement;
import com.cskaoyan.service.technologyService.TechnologyRequirementService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService requirementService;

    //工艺要求页面view
    @RequestMapping("technologyRequirement/find")
    public String  technologyRequirementView(HttpSession session){
        ArrayList<Object> list = new ArrayList<>();
        list.add("technologyRequirement:add");
        list.add("technologyRequirement:edit");
        list.add("technologyRequirement:delete");
        session.setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }

    //工艺要求页面数据
    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public HashMap<String,Object> technologyRequirementManage(int page, int rows){
        List<Technology_requirement> list = requirementService.queyTechnologyRequirement(page,rows);
        int total = requirementService.queryTotalTechnologyRequirement();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //工艺要求view
    @RequestMapping("technologyRequirement/add")
    public String technologyRequirementAddView(){
        return "/WEB-INF/jsp/technologyRequirement_add.jsp";
    }

    //工艺要求新增
    @RequestMapping("technologyRequirement/insert")
    @ResponseBody
    public ResponseVo insertTechnologyRequirement(Technology_requirement requirement){
        ResponseVo responseVo = new ResponseVo();
        int i = requirementService.insertTechnologyRequirement(requirement);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //工艺要求编辑页面弹窗
    @RequestMapping("technologyRequirement/edit")
    public String technologyRequirementEdit(){
        return "/WEB-INF/jsp/technologyRequirement_edit.jsp";
    }
    //工艺要求编辑页面回显数据 technologyRequirement/get_data
    @RequestMapping("technologyRequirement/get_data")
    @ResponseBody
    public List<Technology_requirement> techonlogyRequirementGetData(){
        List<Technology_requirement> list = requirementService.queyAllTechnologyRequirement();
        return list;
    }

}
