package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Process_measure_check;
import com.cskaoyan.bean.Process_measure_checkExample;
import com.cskaoyan.service.quality.Process_measure_checkService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProcessMeasureController {
     /*
        质量监控：工序计量检验部分
     */
     @Autowired
     Process_measure_checkService processMeasureCheckService;


    @RequestMapping("p_measure_check/find")
    public String productMeasure(HttpServletRequest request){
        return ("/WEB-INF/jsp/p_measure_check_list.jsp");
    }


    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public PageVo pmeasureCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Process_measure_check> process_measure_checks = processMeasureCheckService.selectByPage(page, rows);
        PageVo<Process_measure_check> pageVo = new PageVo<>();
        pageVo.setRows(process_measure_checks);
        pageVo.setTotal(process_measure_checks.size());
        return pageVo;
    }

    //点击删除
    @RequestMapping("p_measure_check/delete_judge")
    @ResponseBody
    public void deletep_measure_check_Judge() {

    }

    //完成删除操作，并返回操作结果信息（成功与否）
    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(@RequestParam("ids") String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        Process_measure_checkExample example = new Process_measure_checkExample();
        Process_measure_checkExample.Criteria criteria = example.createCriteria();
        criteria.andPMeasureCheckIdIn(Arrays.asList(ids));
        int i = processMeasureCheckService.deleteByExample(example);
        if (i >= 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击add
    @RequestMapping("p_measure_check/add_judge")
    @ResponseBody
    public void addJudge(){

    }

    //add跳转jsp
    @RequestMapping("p_measure_check/add")
    public String addPcount(){
        return "/WEB-INF/jsp/p_measure_check_add.jsp";
    }

    //add返回确认信息
    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public ResponseVo insertPcount(Process_measure_check process_measure_check){
        int i = processMeasureCheckService.insert(process_measure_check);
        ResponseVo responseVo = new ResponseVo();
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击编辑
    @RequestMapping("p_measure_check/edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    //点击编辑后出现编辑页面框
    @RequestMapping("p_measure_check/edit")
    public String editUnqualify() {
        return ("/WEB-INF/jsp/p_measure_check_edit.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public ResponseVo updateUnqualify(Process_measure_check process_measure_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = processMeasureCheckService.updateByPrimaryKey(process_measure_check);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过商品id模糊查询不合格商品
    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public PageVo search_unqualify_by_unqualifyId(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Process_measure_check> process_measure_checks = processMeasureCheckService.fuzzyQueryByPMeasureCheckId(page,rows,searchValue);
        PageVo pageVo = new PageVo();
        try{
            pageVo.setRows(process_measure_checks);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }

    }


}
