package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("manufacture/find{id}")
    public String manufacturePage(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }

    @RequestMapping("manufacture/list")
    @ResponseBody
    public List<Manufacture> manufacturePage(int page, int rows) {
        List<Manufacture> manufactureList = manufactureService.manufacturePage(page, rows);
        return manufactureList;
    }

    @RequestMapping("manufacture/get/{id}")
    @ResponseBody
    public Manufacture manufactureGet(@PathVariable("id") String id) {
        Manufacture manufacture = manufactureService.manufactureGet(id);
        return manufacture;
    }

    @RequestMapping("manufacture/edit")
    public String edit(){
        return "/WEB-INF/jsp/manufacture_edit.jsp";
    }

    @RequestMapping("manufacture/manufacture_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("manufacture/update_all")
    @ResponseBody
    public ResponseVo update_all(Manufacture manufacture){
        ResponseVo responseVo = manufactureService.updateManufacture(manufacture);
        return responseVo;
    }

    @RequestMapping("manufacture/add")
    public String add(){
        return "/WEB-INF/jsp/manufacture_add.jsp";
    }

    @RequestMapping("manufacture/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("manufacture/insert")
    @ResponseBody
    public ResponseVo insert(Manufacture manufacture){
        ResponseVo responseVo = manufactureService.insertManufacture(manufacture);
        return responseVo;
    }

    @RequestMapping("manufacture/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }


    @RequestMapping("gi/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = manufactureService.batchDeleteManufactureByIds(Arrays.asList(ids));
        return responseVo;
    }
}
