package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.service.quality.Process_count_checkService;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProcessCountCheckController {
    @Autowired
    Process_count_checkService process_count_checkService;

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
