package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.service.Final_count_checkService;
import com.cskaoyan.service.Process_count_checkService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
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
public class CountCheckController {

    @Autowired
    Final_count_checkService final_count_checkService;
    @Autowired
    Process_count_checkService process_count_checkService;


    @RequestMapping("f_count_check/find")
    public String countCheck(HttpServletRequest request){
        return ("/WEB-INF/jsp/f_count_check_list.jsp");
    }


    @RequestMapping("f_count_check/list")
    @ResponseBody
    public PageVo countCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Final_count_check> final_count_checks = final_count_checkService.selectByPage(page, rows);
        PageVo<Final_count_check> final_count_checkPageVo = new PageVo<>();
        final_count_checkPageVo.setRows(final_count_checks);
        final_count_checkPageVo.setTotal(final_count_checks.size());
        return final_count_checkPageVo;
    }


    @RequestMapping("p_count_check/find")
    public String processCountCheck(HttpServletRequest request){
        return ("/WEB-INF/jsp/p_count_check_list.jsp");
    }

    @RequestMapping("p_count_check/list")
    @ResponseBody
    public PageVo pCountCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Process_count_check> process_count_checks=process_count_checkService.selectByPage(page,rows);
        PageVo<Process_count_check> process_count_checkPageVo = new PageVo<>();
        process_count_checkPageVo.setRows(process_count_checks);
        process_count_checkPageVo.setTotal(process_count_checks.size());
        return process_count_checkPageVo;
    }

}
