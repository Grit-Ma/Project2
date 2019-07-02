package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.service.technology.TechnologyPlanService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService planService;

    //工艺计划view
    @RequestMapping("technologyPlan/find")
    public String technologyPlanView(HttpSession session){
        ArrayList<Object> list = new ArrayList<>();
        list.add("technologyPlan:add");
        list.add("technologyPlan:edit");
        list.add("technologyPlan:delete");
        session.setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }
    //工艺计划数据
    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public HashMap<String,Object> techonlogyPlan(int page, int rows){
        List<TechnologyPlan> list = planService.queyTechonlogyPlan(page,rows);
        int total = planService.queryTotalTechnologyPlan();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //工艺计划添加view technologyPlan/add
    @RequestMapping("technologyPlan/add")
    public String technologyAddView(){
        return "/WEB-INF/jsp/technologyPlan_add.jsp";
    }


    //添加工艺计划 {"status":200,"msg":"OK","data":null}
    @RequestMapping("technologyPlan/insert")
    @ResponseBody
    public ResponseVo insertTechnologyPlan(TechnologyPlan technologyPlan){
        ResponseVo responseVo = new ResponseVo();
        int i = planService.insertTechnologyPlan(technologyPlan);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //编辑工艺计划view technologyPlan/edit
    @RequestMapping("technologyPlan/edit")
    public String technologyPlanEdit(){
        return "/WEB-INF/jsp/technologyPlan_edit.jsp";
    }
    //更新工艺管理
    @RequestMapping("technologyPlan/update_all")
    @ResponseBody
    public ResponseVo updateTechnologyPlan(TechnologyPlan technologyPlan){
        ResponseVo responseVo = new ResponseVo();
        int i = planService.updateTechnologyPlan(technologyPlan);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }


    //多选删除工艺计划
    @RequestMapping("technologyPlan/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(String[] ids){
        int result = planService.deleteBatch(ids);
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

    //technologyPlan/get_data
    @RequestMapping("technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> technologyPlanGetData(){
        List<TechnologyPlan> list = planService.queryAllTechnologyPlan();
        return list;
    }

    //technologyPlan/get/001
    @RequestMapping("technologyPlan/get/{technologyPlanId}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlanById(@PathVariable("technologyPlanId") String technologyPlanId){
        TechnologyPlan technologyPlan = planService.queryTechnologyPlanById(technologyPlanId);
        return technologyPlan;
    }

    //搜索        technologyPlan/search_technologyPlan_by_technologyPlanId?searchValue=11&page=1&rows=30
    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public HashMap<String,Object> searchByTechnologyPlanId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "planId";
        List<TechnologyPlan> list = planService.searchByTechnologyPlanId(searchValue ,page,rows,flag);
        int total = planService.searchByTechnologyPlanIdTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //technologyPlan/search_technologyPlan_by_technologyName?searchValue=222&page=1&rows=30

    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public HashMap<String,Object> search_technologyPlan_by_technologyName(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "planName";
        List<TechnologyPlan> list = planService.searchByTechnologyPlanIdOrName(searchValue,page,rows,flag);
        int total = planService.searchByTechnologyPlanIdOrNameTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
}
