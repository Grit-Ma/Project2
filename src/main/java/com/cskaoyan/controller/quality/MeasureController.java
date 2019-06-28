package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Final_measuret_check;
import com.cskaoyan.bean.Process_measure_check;
import com.cskaoyan.service.Final_measuret_checkService;
import com.cskaoyan.service.Process_measure_checkService;
import com.cskaoyan.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MeasureController {
    @Autowired
    Final_measuret_checkService final_measuret_checkService;
    @Autowired
    Process_measure_checkService processMeasureCheckService;

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

    @RequestMapping("p_measure_check/find")
    public String productMeasure(HttpServletRequest request){
        return ("/WEB-INF/jsp/p_measure_check_list.jsp");
    }


    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public PageVo pmeasureCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Process_measure_check> process_measure_checks = processMeasureCheckService.selectByPage(page, rows);
        PageVo<Process_measure_check> process_measure_checkPageVo = new PageVo<>();
        process_measure_checkPageVo.setRows(process_measure_checks);
        process_measure_checkPageVo.setTotal(process_measure_checks.size());
        return process_measure_checkPageVo;
    }


}
