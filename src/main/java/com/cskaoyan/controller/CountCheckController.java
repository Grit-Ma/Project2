package com.cskaoyan.controller;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.service.Final_count_checkService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CountCheckController {

    @Autowired
    Final_count_checkService final_count_checkService;

    @RequestMapping("f_count_check/find")
    public String countCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList arrayList = new ArrayList();
        arrayList.add("fCountCheck:add");
        arrayList.add("fCountCheck:edit");
        arrayList.add("fCountCheck:delete");
        session.setAttribute("sysPermissionList", arrayList);
        return ("/WEB-INF/jsp/p_measure_check_list.jsp");
    }

    @RequestMapping("f_count_check/list")
    public PageVo countCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        System.out.println(page);
        List<Final_count_check> final_count_checks = final_count_checkService.selectByPage(page, rows);
        System.out.println(final_count_checks);
        PageVo<Final_count_check> final_count_checkPageVo = new PageVo<>();
        final_count_checkPageVo.setRows(final_count_checks);
        final_count_checkPageVo.setTotal(final_count_checks.size());
        return final_count_checkPageVo;
    }

    @RequestMapping("p_measure_check/list")
    public String checkMeasure(@RequestParam("page") int page, @RequestParam("rows") int rows){
        return "redirect:/f_count_check/list?page="+page+"&rows="+rows;
    }

}
