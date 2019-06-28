package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
