package com.cskaoyan.controller.technologyController;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.technologyService.TechnologyProcessServie;
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
public class TechnologyProcessController {
    @Autowired
    TechnologyProcessServie processService;
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
        List<Process> list = processService.queyProcess(page,rows);
        int total = processService.queryTotalProcess();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
    //工序管理增加view        process/add
    @RequestMapping("process/add")
    public String processAddView(){
        return "/WEB-INF/jsp/process_add.jsp";
    }
    //工序管理增加    process/insert
    @RequestMapping("process/insert")
    @ResponseBody
    public ResponseVo insertProcess(Process process){
        ResponseVo responseVo = new ResponseVo();
        int i = processService.insertProcess(process);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //工序管理编辑view
    //工艺管理页面编辑页面弹窗
    @RequestMapping("process/edit")
    public String processEdit(){
        return "/WEB-INF/jsp/process_edit.jsp";
    }

    //更新工序管理
    @RequestMapping("process/update_all")
    @ResponseBody
    public ResponseVo updateProcess(Process process){
        ResponseVo responseVo = new ResponseVo();
        int i = processService.updateProcess(process);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }
    //工序管理删除
    @RequestMapping("process/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(String[] ids){
        int result = processService.deleteBatch(ids);
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

    //搜索        process/search_process_by_processId?searchValue=1&page=1&rows=30
    @RequestMapping("process/search_process_by_processId")
    @ResponseBody
    public HashMap<String,Object> searchByProcessId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "processId";
        List<Process> list = processService.searchByProcessId(searchValue ,page,rows,flag);
        int total = processService.searchByProcessIdTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //process/search_process_by_technologyPlanId?searchValue=11&page=1&rows=30
    @RequestMapping("process/search_process_by_technologyPlanId")
    @ResponseBody
    public HashMap<String,Object> search_process_by_technologyPlanId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "planId";
        List<Process> list = processService.searchByProcessByPlanId(searchValue,page,rows,flag);
        int total = processService.searchByProcessByPlanIdTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    @RequestMapping("process/get_data")
    @ResponseBody
    public List<Process> technologyPlanGetData(){
        List<Process> list = processService.queryAllProcess();
        return list;
    }

}
