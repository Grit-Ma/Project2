package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Final_measuret_check;
import com.cskaoyan.bean.Final_measuret_checkExample;
import com.cskaoyan.service.quality.Final_measuret_checkService;
import com.cskaoyan.tool.PageTool;
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
public class MeasureController {
    @Autowired
    Final_measuret_checkService final_measuret_checkService;

    /*
       质量监控： 成品计量检验部分
     */

    @RequestMapping("measure/find")
    public String findAllMeasure(HttpServletRequest request) {
        return ("/WEB-INF/jsp/measurement_list.jsp");
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public PageVo checkMeasure(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        List<Final_measuret_check> final_measuret_checks = final_measuret_checkService.selectByPage(page,rows);
        PageVo<Final_measuret_check> objectPageVo = new PageVo(final_measuret_checks.size(), final_measuret_checks);
        return objectPageVo;
    }

    //点击删除
    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public void deletefMeasureCheckJudge() {

    }

    //完成删除操作，并返回操作结果信息（成功与否）
    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public ResponseVo deletefMeasureBatch(@RequestParam("ids") String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        Final_measuret_checkExample final_measuret_checkExample = new Final_measuret_checkExample();
        Final_measuret_checkExample.Criteria criteria = final_measuret_checkExample.createCriteria();
        criteria.andFMeasureCheckIdIn(Arrays.asList(ids));
        int i = final_measuret_checkService.deleteByExample(final_measuret_checkExample);
        if (i >= 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }


    //点击编辑
    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public void editMeasureJudge() {

    }

    //点击编辑后出现编辑页面框
    @RequestMapping("measure/edit")
    public String editMeasure() {
        return ("/WEB-INF/jsp/measurement_add.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("measure/update_all")
    @ResponseBody
    public ResponseVo updateMeasure(Final_measuret_check final_measuret_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_measuret_checkService.updateByPrimaryKey(final_measuret_check);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }


    // 点击添加一条成品计量检验
    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public void addMeasureJudge() {

    }

    //点击添加出现添加页面显示框
    @RequestMapping("measure/add")
    public String addMeasure() {
        return ("/WEB-INF/jsp/measurement_add.jsp");
    }


    //提交添加操作，并返回操作结果状态信息
    @RequestMapping("measure/insert")
    @ResponseBody
    public ResponseVo insertMeasure(Final_measuret_check final_measuret_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_measuret_checkService.insert(final_measuret_check);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过成品id模糊查询成品计量质检
    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public PageVo search_measure_by_measureId(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Final_measuret_check>  final_measuret_checks=final_measuret_checkService.fuzzyQueryByPid(page,rows,searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo.setRows(final_measuret_checks);
            pageVo.setTotal(final_measuret_checks.size());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }
    }

    //通过订单编号模糊查询成品计量质检
    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public PageVo search_measure_by_measureName(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Final_measuret_check>  final_measuret_checks=final_measuret_checkService.fuzzyQueryByOid(page,rows,searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo.setRows(final_measuret_checks);
            pageVo.setTotal(final_measuret_checks.size());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }
    }


}
