package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.Final_count_check;
import com.cskaoyan.bean.Final_count_checkExample;
import com.cskaoyan.service.quality.Final_count_checkService;
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
public class CountCheckController {


/*
       质量监控：成品计数质检
 */


@Autowired
Final_count_checkService final_count_checkService;

    //获取所有成品计量质检的页面跳转
    @RequestMapping("f_count_check/find")
    public String countCheck(HttpServletRequest request){
        return ("/WEB-INF/jsp/f_count_check_list.jsp");
    }

    //获取所有成品计量质检的数据返回
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public PageVo countCheckList(@RequestParam("page") int page, @RequestParam("rows") int rows){
        List<Final_count_check> final_count_checks = final_count_checkService.selectByPage(page, rows);
        PageVo<Final_count_check> final_count_checkPageVo = new PageVo<>();
        final_count_checkPageVo.setRows(final_count_checks);
        final_count_checkPageVo.setTotal(final_count_checks.size());
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
    public ResponseVo insertf_count_check(Final_count_check final_count_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_count_checkService.insert(final_count_check);
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
        Final_count_checkExample f_count_check_applyExample = new Final_count_checkExample();
        Final_count_checkExample.Criteria criteria = f_count_check_applyExample.createCriteria();
        criteria.andFCountCheckIdIn(Arrays.asList(ids));
        int i = final_count_checkService.deleteByExample(f_count_check_applyExample);
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
    public ResponseVo updateF_count_check(Final_count_check final_count_check) {
        ResponseVo responseVo = new ResponseVo();
        int i = final_count_checkService.updateByPrimaryKey(final_count_check);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过成品计数质检编号模糊查询成品计量质检
    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public PageVo search_count_by_countId(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Final_count_check> final_count_checks =final_count_checkService.fuzzyQueryByCountCheckId(page,rows,searchValue);
        PageVo<Final_count_check> pageVo = new PageVo<>();
        try{
            pageVo.setRows(final_count_checks);
            pageVo.setTotal(final_count_checks.size());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return pageVo;
        }
    }

    //通过订单编号模糊查询成品计量质检
    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public PageVo search_count_by_countName(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<Final_count_check> final_count_checks =final_count_checkService.fuzzyQueryByCountOrderId(page,rows,searchValue);
        PageVo<Final_count_check> pageVo = new PageVo<>();
        try{
            pageVo.setRows(final_count_checks);
            pageVo.setTotal(final_count_checks.size());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return pageVo;
        }
    }
}
