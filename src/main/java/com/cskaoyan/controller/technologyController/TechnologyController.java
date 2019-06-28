package com.cskaoyan.controller.technologyController;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.technologyService.TechnologyService;
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
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    //工艺管理view
    @RequestMapping("technology/find")
    public String  techonlogyManageView(HttpSession session){
        ArrayList<Object> list = new ArrayList<>();
        list.add("technology:add");
        list.add("technology:edit");
        list.add("technology:delete");
        session.setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    //list返回json
    //pags和rows为mvc自动封装的参数(url中的)
    //工艺管理数据
    @RequestMapping("technology/list")
    @ResponseBody
    public HashMap<String,Object> techonlogyManage(int page,int rows){
        List<Technology> list = technologyService.queyTechnology(page,rows);
        int total = technologyService.queryTotalTechonlogyManage();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    //对所有权限控制放行
    @RequestMapping("*/*_judge")
    @ResponseBody
    public void judge(){}

    //工艺管理添加弹窗页面
    @RequestMapping("technology/add")
    public String technologyAddView(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }


    //添加工艺{"status":200,"msg":"OK","data":null}
    @RequestMapping("technology/insert")
    @ResponseBody
    public ResponseVo insertTechnology(Technology technology){
        ResponseVo responseVo = new ResponseVo();
        int i = technologyService.insertTechnology(technology);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //工艺管理页面编辑页面弹窗
    @RequestMapping("technology/edit")
    public String technologyEdit(){
        return "/WEB-INF/jsp/technology_edit.jsp";
    }

     //technology/get_data
     @RequestMapping({"technology/get_data","technologyRequirement/get_data"})
     @ResponseBody
     public List<Technology> technologyGetData(){
         List<Technology> list = technologyService.queyAllTechnology();
         return list;
     }


    //更新工艺管理
    @RequestMapping("technology/update_all")
    @ResponseBody
    public ResponseVo updateTechnology(Technology technology){
        ResponseVo responseVo = new ResponseVo();
        int i = technologyService.updateTechnology(technology);
        if(i >=1){
            responseVo.setStatus(200);
            responseVo.setMsg("ok");
            return responseVo;
        }else {
            responseVo.setMsg("false");
            return responseVo;
        }
    }

    //多选删除工艺管理technology/delete_batch
    @RequestMapping("technology/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(String[] ids){
        int result = technologyService.deleteBatch(ids);
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

    //搜索technology/search_technology_by_technologyId?searchValue=123&page=1&rows=30
    @RequestMapping("technology/search_technology_by_technologyId")
    @ResponseBody
    public HashMap<String,Object> searchByTechnologyId(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "TechnologyId";
        List<Technology> list = technologyService.searchByTechnologyIdOrName(searchValue ,page,rows,flag);
        int total = technologyService.searchByTechnologyIdOrNameTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }
    //返回total和rolls
    //搜索technology/search_technology_by_technologyName?searchValue=2&page=1&rows=30
    @RequestMapping("technology/search_technology_by_technologyName")
    @ResponseBody
    public HashMap<String,Object> searchByTechnologyName(String searchValue,int page,int rows){
        HashMap<String, Object> map = new HashMap<>();
        String flag = "TechnologyName";
        List<Technology> list = technologyService.searchByTechnologyIdOrName(searchValue,page,rows,flag);
        int total = technologyService.searchByTechnologyIdOrNameTotal(searchValue,flag);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }



    @RequestMapping("technology/get/{TechnologyId}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable("TechnologyId") String TechnologyId){
        System.out.println();
        Technology technology = technologyService.queryTechnologyById(TechnologyId);
        return technology;
    }

    @RequestMapping("technology/get/{technologyId}")
    @ResponseBody
    public Technology getTechnologyPlanById(@PathVariable("technologyId") String technologyId){
        Technology technology = technologyService.queryTechnologyPlanById(technologyId);
        return technology;
    }

}
