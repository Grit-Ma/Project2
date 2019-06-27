package com.cskaoyan.controller;

import com.cskaoyan.bean.Final_measuret_check;
import com.cskaoyan.bean.Unqualify_apply;
import com.cskaoyan.service.Final_measuret_checkService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MeasureController {
    @Autowired
    Final_measuret_checkService final_measuret_checkService;

    @RequestMapping("measure/find")
    public String findAllMeasure(HttpServletRequest request) {
        return ("/WEB-INF/jsp/measurement_list.jsp");
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public PageVo checkUnqualify(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        List<Final_measuret_check> final_measuret_checks = final_measuret_checkService.selectByPage(page,rows);
        PageVo<Final_measuret_check> objectPageVo = new PageVo(final_measuret_checks.size(), final_measuret_checks);
        return objectPageVo;
    }





}
