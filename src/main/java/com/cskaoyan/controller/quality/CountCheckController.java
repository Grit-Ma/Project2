package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.quality.FinalCountCheck;
import com.cskaoyan.bean.quality.FinalCountCheckExample;
import com.cskaoyan.service.quality.FinalCountCheckService;
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
public class CountCheckController {


/*
       质量监控：成品计数质检
 */


    @Autowired
    FinalCountCheckService final_countCheckService;

    //获取所有成品计量质检的页面跳转
    @RequestMapping("f_count_check/find")
    public String countCheck(HttpServletRequest request) {
        return ("/WEB-INF/jsp/f_count_check_list.jsp");
    }

    //获取所有成品计量质检的数据返回
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public PageVo countCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        List<FinalCountCheck> final_countChecks = final_countCheckService.selectByPage(page, rows);
        PageVo<FinalCountCheck> final_count_checkPageVo = new PageVo<>();
        final_count_checkPageVo.setRows(final_countChecks);
        final_count_checkPageVo.setTotal(final_countChecks.size());
        return final_count_checkPageVo;
    }

    // 点击添加成品计量质检
    @RequestMapping("f_count_check/add_judge")
    @ResponseBody
    public void addJudge() {

    }

    //点击添加出现添加页面显示框
    @RequestMapping("f_count_check/add")
    public String addf_count_check() {
        return ("/WEB-INF/jsp/f_count_check_add.jsp");
    }


    //提交添加操作，并返回操作结果状态信息
    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public ResponseVo insertf_count_check(FinalCountCheck final_countCheck) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_countCheckService.insert(final_countCheck);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击删除
    @RequestMapping("f_count_check/delete_judge")
    @ResponseBody
    public void deletef_count_check_Judge() {

    }

    //完成删除操作，并返回操作结果信息（成功与否）
    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(@RequestParam("ids") String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        FinalCountCheckExample f_count_check_applyExample = new FinalCountCheckExample();
        FinalCountCheckExample.Criteria criteria = f_count_check_applyExample.createCriteria();
        criteria.andFCountCheckIdIn(Arrays.asList(ids));
        int i = final_countCheckService.deleteByExample(f_count_check_applyExample);
        if (i >= 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击编辑
    @RequestMapping("f_count_check/edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    //点击编辑后出现编辑页面框
    @RequestMapping("f_count_check/edit")
    public String editF_count_check() {
        return ("/WEB-INF/jsp/f_count_check_edit.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public ResponseVo updateF_count_check(FinalCountCheck final_countCheck) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_countCheckService.updateByPrimaryKey(final_countCheck);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过成品计数质检编号模糊查询成品计量质检
    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public PageVo search_count_by_countId(@RequestParam("page") int page, @RequestParam("rows") int rows, String searchValue) {
        List<FinalCountCheck> final_countChecks = final_countCheckService.fuzzyQueryByCountCheckId(page, rows, searchValue);
        PageVo<FinalCountCheck> pageVo = new PageVo<>();
        try {
            pageVo.setRows(final_countChecks);
            pageVo.setTotal(final_countChecks.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return pageVo;
        }
    }

    //通过订单编号模糊查询成品计量质检
    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public PageVo search_count_by_countName(@RequestParam("page") int page, @RequestParam("rows") int rows, String searchValue) {
        List<FinalCountCheck> final_countChecks = final_countCheckService.fuzzyQueryByCountOrderId(page, rows, searchValue);
        PageVo<FinalCountCheck> pageVo = new PageVo<>();
        try {
            pageVo.setRows(final_countChecks);
            pageVo.setTotal(final_countChecks.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return pageVo;
        }
    }

    //  修改备注信息
    @RequestMapping("f_count_check/update_note")
    @ResponseBody
    public ResponseVo update_note(@RequestParam("fCountCheckId") String pCountCheckId, @RequestParam("note") String note) {
        FinalCountCheck final_countCheck = final_countCheckService.selectByPrimaryKey(pCountCheckId);
        final_countCheck.setNote(note);
        int i = final_countCheckService.updateByPrimaryKey(final_countCheck);
        ResponseVo responseVo = new ResponseVo();
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
}
