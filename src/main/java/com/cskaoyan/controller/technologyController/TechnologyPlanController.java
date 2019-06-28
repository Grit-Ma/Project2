package com.cskaoyan.controller.technologyController;

import com.cskaoyan.bean.Technology_plan;
import com.cskaoyan.service.technologyService.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        List<Technology_plan> list = planService.queyTechonlogyPlan(page,rows);
        int total = planService.queryTotalTechnologyPlan();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
}
