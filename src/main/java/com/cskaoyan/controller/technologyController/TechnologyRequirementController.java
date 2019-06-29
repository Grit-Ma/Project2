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

    //工艺要求编辑页面修改
    @RequestMapping("technologyRequirement/update_all")
    @ResponseBody
    public ResponseVo updateTechnologyRequirement(Technology_requirement technologyRequirement){
        ResponseVo responseVo = new ResponseVo();
        int i = requirementService.updateTechnologyRequirement(technologyRequirement);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //批量删除工艺要求      technologyRequirement/delete_batch
    @RequestMapping("technologyRequirement/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(String[] ids){
        int result = requirementService.deleteBatch(ids);
        ResponseVo responseVo = new ResponseVo();
        if(result >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }
    //搜索
    //technologyRequirement/search_technologyRequirement_by_technologyRequirementId?searchValue=1&page=1&rows=30
    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public HashMap<String,Object> searchByTechnologyRequirementId(int searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "technologyRequirementId";
        List<Technology_requirement> list = requirementService.searchByTechnologyRequirementId(searchValue + "",page,rows,flag);
        int total = requirementService.searchByTechnologyRequirementIdTotal(searchValue + "",flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
    //technologyRequirement/search_technologyRequirement_by_technologyName?searchValue=weiwuxian&page=1&rows=30

    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public HashMap<String,Object> search_technology_by_technologyName(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "technologyRequirementName";
        List<Technology_requirement> list = requirementService.searchByTechnologyIdOrName(searchValue,page,rows,flag);
        int total = requirementService.searchByTechnologyIdOrNameTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //technologyRequirement/update_requirement
    @RequestMapping("technologyRequirement/update_requirement")
    @ResponseBody
    public ResponseVo update_requirement(String technologyRequirementId,String requirement){
        int result = requirementService.update_requirement(technologyRequirementId,requirement);
        ResponseVo responseVo = new ResponseVo();
        if(result >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }
}
