package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.Work;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("work/find{id}")
    public String workManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/work_list.jsp";
    }

    @RequestMapping("work/list")
    @ResponseBody
    public List<Work> workPage(int page, int rows) {
        List<Work> workList = workService.workPage(page, rows);
        return workList;
    }

    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> workGetData() {
        List<Work> workList = workService.workGetData();
        return workList;
    }

    @RequestMapping("work/get/{id}")
    @ResponseBody
    public Work workGetData(@PathVariable("id") String id) {
        Work work = workService.workGet(id);
        return work;
    }
}
