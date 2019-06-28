package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Process_count_check;
import com.cskaoyan.bean.Process_count_checkExample;
import com.cskaoyan.service.quality.Process_count_checkService;
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

/*
    质量监控：工序计数质检部分
 */

@Controller
public class ProcessCountCheckController {
    @Autowired
    Process_count_checkService process_count_checkService;

    //查找工序计数质检跳转页面
    @RequestMapping("p_count_check/find")
    public String processCountCheck(HttpServletRequest request){
        return ("/WEB-INF/jsp/p_count_check_list.jsp");
    }

    //查找工序计数质检，获取数据，返回为json类型
    @RequestMapping("p_count_check/list")
    @ResponseBody
    public PageVo pCountCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Process_count_check> process_count_checks=process_count_checkService.selectByPage(page,rows);
        PageVo<Process_count_check> pageVo = new PageVo<>();
        pageVo.setRows(process_count_checks);
        pageVo.setTotal(process_count_checks.size());
        return pageVo;
    }

    //点击删除
    @RequestMapping("p_count_check/delete_judge")
    @ResponseBody
    public void deletep_count_check_Judge() {

    }

    //完成删除操作，并返回操作结果信息（成功与否）
    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(@RequestParam("ids") String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        Process_count_checkExample example = new Process_count_checkExample();
        Process_count_checkExample.Criteria criteria = example.createCriteria();
        criteria.andPCountCheckIdIn(Arrays.asList(ids));
        int i = process_count_checkService.deleteByExample(example);
        if (i >= 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击add
    @RequestMapping("p_count_check/add_judge")
    @ResponseBody
    public void addJudge(){

    }

    //add跳转jsp
    @RequestMapping("p_count_check/add")
    public String addPcount(){
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }

    //add返回确认信息
    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public ResponseVo insertPcount(Process_count_check process_count_check){
        int i = process_count_checkService.insert(process_count_check);
        ResponseVo responseVo = new ResponseVo();
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击编辑
    @RequestMapping("p_count_check/edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    //点击编辑后出现编辑页面框
    @RequestMapping("p_count_check/edit")
    public String editUnqualify() {
        return ("/WEB-INF/jsp/p_count_check_add.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public ResponseVo updateUnqualify(Process_count_check process_count_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = process_count_checkService.updateByPrimaryKey(process_count_check);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过商品id模糊查询不合格商品
    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public PageVo search_unqualify_by_unqualifyId(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Process_count_check> process_measure_checks = process_count_checkService.fuzzyQueryByPCountCheckId(page,rows,searchValue);
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
