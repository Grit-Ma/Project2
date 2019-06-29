package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Work;
import com.cskaoyan.service.WorkService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("work/find{id}")
    public String workManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/work_list.jsp";
    }

    @RequestMapping("work/list")
    @ResponseBody
    public PageVo workPage(int page, int rows) {
        PageVo workList = workService.workPage(page, rows);
        return workList;
    }

    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> workGetData() {
        List<Work> workList = workService.workGetData();
        return workList;
    }

    @RequestMapping("work/get/{id}")
    @ResponseBody
    public Work workGetData(@PathVariable("id") String id) {
        Work work = workService.workGet(id);
        return work;
    }

    @RequestMapping("work/edit")
    public String edit(){
        return "/WEB-INF/jsp/work_edit.jsp";
    }

    @RequestMapping("work/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("work/update_all")
    @ResponseBody
    public ResponseVo update_all(Work work){
        ResponseVo responseVo = workService.updateWork(work);
        return responseVo;
    }

    @RequestMapping("work/add")
    public String add(){
        return "/WEB-INF/jsp/work_add.jsp";
    }

    @RequestMapping("work/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("work/insert")
    @ResponseBody
    public ResponseVo insert(Work work){
        ResponseVo responseVo = workService.insertWork(work);
        return responseVo;
    }

    @RequestMapping("work/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }

    @RequestMapping("work/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = workService.batchDeleteWorkByIds(Arrays.asList(ids));
        return responseVo;
    }

    @RequestMapping("work/search_work_by_workId")
    @ResponseBody
    public PageVo search_work_by_workId(String searchValue, int page, int rows){
        PageVo pageVo = workService.searchWorkByWorkId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("work/search_work_by_workProduct")
    @ResponseBody
    public PageVo search_work_by_workProduct(String searchValue, int page, int rows){
        PageVo pageVo = workService.searchWorkByWorkProduct(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("work/search_work_by_workDevice")
    @ResponseBody
    public PageVo search_work_by_workDevice(String searchValue, int page, int rows){
        PageVo pageVo = workService.searchWorkByWorkDevice(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("work/search_work_by_workProcess")
    @ResponseBody
    public PageVo search_work_by_workProcess(String searchValue, int page, int rows){
        PageVo pageVo = workService.searchWorkByWorkProcess(searchValue, page, rows);
        return pageVo;
    }
}
