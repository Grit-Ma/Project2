package com.cskaoyan.controller.quality;

import com.cskaoyan.bean.quality.UnqualifyApply;
import com.cskaoyan.bean.quality.UnqualifyApplyExample;
import com.cskaoyan.service.quality.UnqualifyApplyService;
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


/*
    质量监控：不合格商品部分
 */

@Controller
public class UnqualityController {
    @Autowired
    UnqualifyApplyService unqualify_applyService;


    //查找不合格产品跳转页面
    @RequestMapping("unqualify/find")
    public String findAllUnqualify(HttpServletRequest request) {
        return ("/WEB-INF/jsp/unqualify_list.jsp");
    }

    //查询不合格产品，显示数据，返回为json类型
    @RequestMapping("unqualify/list")
    @ResponseBody
    public PageVo checkUnqualify(@RequestParam("page") int page, @RequestParam("rows") int rows) {
        List<UnqualifyApply> unqualify_applies = unqualify_applyService.selectAll();
        PageVo pageVo = PageTool.getPageVo(unqualify_applies, page, rows);
        return pageVo;
    }

    //点击删除
    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public void deleteUnqualify_Judge() {

    }

    //完成删除操作，并返回操作结果信息（成功与否）
    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(@RequestParam("ids") String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        UnqualifyApplyExample unqualify_applyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualify_applyExample.createCriteria();
        criteria.andUnqualifyApplyIdIn(Arrays.asList(ids));
        int i = unqualify_applyService.deleteByExample(unqualify_applyExample);
        if (i >= 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    // 点击添加不合格产品
    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public void addJudge() {

    }

    //点击添加出现添加页面显示框
    @RequestMapping("unqualify/add")
    public String addUnqualify() {
        return ("/WEB-INF/jsp/unqualify_add.jsp");
    }


    //提交添加操作，并返回操作结果状态信息
    @RequestMapping("unqualify/insert")
    @ResponseBody
    public ResponseVo insertUnqualify(UnqualifyApply unqualify_apply) {
        ResponseVo responseVo = new ResponseVo();
        int i = unqualify_applyService.insert(unqualify_apply);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //点击编辑
    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    //点击编辑后出现编辑页面框
    @RequestMapping("unqualify/edit")
    public String editUnqualify() {
        return ("/WEB-INF/jsp/unqualify_edit.jsp");
    }


    //提交编辑，进行更新操作并返回操作结果状态信息
    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public ResponseVo updateUnqualify(UnqualifyApply unqualify_apply) {
        ResponseVo responseVo = new ResponseVo();
        int i = unqualify_applyService.updateByPrimaryKey(unqualify_apply);
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //通过商品id模糊查询不合格商品
    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public PageVo search_unqualify_by_unqualifyId(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){
        List<UnqualifyApply> unqualify_applies =unqualify_applyService.fuzzyqueryByPid(searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo = PageTool.getPageVo(unqualify_applies, page, rows);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }
    }

    //通过商品名字模糊查询不合格品
    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public PageVo search_unqualify_by_unqualifyName(@RequestParam("page") int page, @RequestParam("rows") int rows,String searchValue){

        List<UnqualifyApply> unqualify_applies =unqualify_applyService.fuzzyqueryByPname(searchValue);
        PageVo pageVo  =new PageVo();
        try{
            pageVo = PageTool.getPageVo(unqualify_applies, page, rows);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            return pageVo;
        }
    }

    //  修改备注信息
    @RequestMapping("unqualify/update_note")
    @ResponseBody
    public ResponseVo update_note(@RequestParam("unqualifyApplyId") String pCountCheckId, @RequestParam("note") String note) {
        UnqualifyApply unqualify_apply = unqualify_applyService.selectByPrimaryKey(pCountCheckId);
        unqualify_apply.setNote(note);
        int i = unqualify_applyService.updateByPrimaryKey(unqualify_apply);
        ResponseVo responseVo = new ResponseVo();
        if (i == 1) {
            responseVo.setMsg("ok");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

}
