package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.service.quality.Final_count_checkService;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CountCheckController {

    @Autowired
    Final_count_checkService final_count_checkService;


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


}
