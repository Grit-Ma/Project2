package com.cskaoyan.controller.technologyController;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.technologyService.TechnologyProcessServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TechnologyProcessController {
    @Autowired
    TechnologyProcessServie processServie;
    //工序管理view
    @RequestMapping("process/find")
    public String processFindView(HttpSession session){
        ArrayList<Object> list = new ArrayList<>();
        list.add("process:add");
        list.add("process:edit");
        list.add("process:delete");
        session.setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/process_list.jsp";
    }
    //工序管理数据
    @RequestMapping("process/list")
    @ResponseBody
    public HashMap<String,Object> processList(int page, int rows){
        List<Process> list = processServie.queyProcess(page,rows);
        int total = processServie.queryTotalProcess();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
}
