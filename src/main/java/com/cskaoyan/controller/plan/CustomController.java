package com.cskaoyan.controller.plan;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.service.CustomService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomController {
    @Autowired
    CustomService customService;

    @RequestMapping("custom/find{id}")
    public String customManager(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/custom_list.jsp";
    }

    @RequestMapping("custom/list")
    @ResponseBody
    public List<Custom> customList(int page, int rows) {
        List<Custom> customList = customService.customPage(page, rows);
        return customList;
    }

    @RequestMapping("custom/add{id}")
    public String customAdd(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/custom_add.jsp";
    }

    @RequestMapping("custom/add_judge")
    public String customAddItem() { return "/WEB-INF/jsp/custom_add.jsp"; }

    @RequestMapping("custom/insert")
    @ResponseBody
    public ResponseVo customInsert(Custom custom) {
        int i = customService.customAdd(custom);
        if (i == 1) {
            return new ResponseVo(200, custom, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("custom/edit{id}")
    public String customEdit(@PathVariable("id") String id) {
        return "/WEB-INF/jsp/custom_edit.jsp";
    }

    @RequestMapping("custom/edit_judge")
    public String customEditItem() { return "/WEB-INF/jsp/custom_edit.jsp"; }

    @RequestMapping("custom/update_all")
    @ResponseBody
    public ResponseVo customUpdate(Custom custom) {
        int i = customService.customUpdate(custom);
        if (i == 1) {
            return new ResponseVo(200, custom, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("custom/delete_judge")
    public String customDeleteItem() { return "/WEB-INF/jsp/custom_edit.jsp"; }

    @RequestMapping("custom/delete_batch")
    @ResponseBody
    public ResponseVo customDelete(String[] ids) {
        List<String> list = new ArrayList<>();
        for (String id : ids) {
            list.add(id);
        }
        int i = customService.customDelete(list);
        if (i == 1) {
            return new ResponseVo(200, null, "ok");
        }
        return new ResponseVo(400, null, "bad request");
    }

    @RequestMapping("custom/search_custom_by_customId")
    @ResponseBody
    public List<Custom> searchByCustomId(String searchValue, int page, int rows) {
        List<Custom> customList = customService.searchByCustomId(searchValue, page, rows);
        return customList;
    }

    @RequestMapping("custom/search_custom_by_customName")
    @ResponseBody
    public List<Custom> searchByCustomName(String searchValue, int page, int rows) {
        List<Custom> customList = customService.searchByCustomName(searchValue, page, rows);
        return customList;
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public  List<Custom> customGet() {
        List<Custom> customList = customService.customGetData();
        return customList;
    }
}
