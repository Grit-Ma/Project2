package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.quality.FinalMeasuretCheck;
import com.cskaoyan.bean.quality.FinalMeasuretCheckExample;
import com.cskaoyan.service.quality.FinalMeasuretCheckService;
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
    FinalMeasuretCheckService final_measuretCheckService;

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
        List<FinalMeasuretCheck> final_measuretChecks = final_measuretCheckService.selectByPage(page,rows);
        PageVo<FinalMeasuretCheck> objectPageVo = new PageVo(final_measuretChecks.size(), final_measuretChecks);
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
        FinalMeasuretCheckExample final_measuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = final_measuretCheckExample.createCriteria();
        criteria.andFMeasureCheckIdIn(Arrays.asList(ids));
        int i = final_measuretCheckService.deleteByExample(final_measuretCheckExample);
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
        return ("/WEB-INF/jsp/measurement_edit.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("measure/update_all")
    @ResponseBody
    public ResponseVo updateMeasure(FinalMeasuretCheck final_measuretCheck) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_measuretCheckService.updateByPrimaryKey(final_measuretCheck);
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
    public ResponseVo insertMeasure(FinalMeasuretCheck final_measuretCheck) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_measuretCheckService.insert(final_measuretCheck);
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
        List<FinalMeasuretCheck> final_measuretChecks = final_measuretCheckService.fuzzyQueryByPid(page,rows,searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo.setRows(final_measuretChecks);
            pageVo.setTotal(final_measuretChecks.size());
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
        List<FinalMeasuretCheck> final_measuretChecks = final_measuretCheckService.fuzzyQueryByOid(page,rows,searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo.setRows(final_measuretChecks);
            pageVo.setTotal(final_measuretChecks.size());
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }
    }

    //  修改备注信息
    @RequestMapping("measure/update_note")
    @ResponseBody
    public ResponseVo update_note(@RequestParam("fMeasureCheckId") String pCountCheckId, @RequestParam("note") String note) {
        FinalMeasuretCheck final_measuretCheck = final_measuretCheckService.selectByPrimaryKey(pCountCheckId);
        final_measuretCheck.setNote(note);
        int i = final_measuretCheckService.updateByPrimaryKey(final_measuretCheck);
        ResponseVo responseVo = new ResponseVo();
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

}
