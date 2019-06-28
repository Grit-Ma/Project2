package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Material_receive;
import com.cskaoyan.service.material.MaterialReceiveService;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class MaterialReceiveController {

    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("materialReceive/find")
    public String find(){
        return "/WEB-INF/jsp/materialReceive_list.jsp";
    }

    @RequestMapping("materialReceive/list")
    @ResponseBody
    public PageVo list(int page, int rows){
        PageVo pageVo = materialReceiveService.getPage(page, rows);
        return pageVo;
    }

    @RequestMapping("materialReceive/edit")
    public String edit(){
        return "/WEB-INF/jsp/materialReceive_edit.jsp";
    }

    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public ResponseVo update_all(Material_receive material_receive){
        ResponseVo responseVo = materialReceiveService.updateMaterialReceive(material_receive);
        return responseVo;
    }

    @RequestMapping("materialReceive/search_materialReceive_by_receiveId")
    @ResponseBody
    public PageVo search_materialReceive_by_materialReceiveId(String searchValue, int page, int rows){
        PageVo pageVo = materialReceiveService.searchMaterialReceiveByReceiveId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("materialReceive/search_materialReceive_by_materialId")
    @ResponseBody
    public PageVo search_materialReceive_by_materialId(String searchValue, int page, int rows){
        PageVo pageVo = materialReceiveService.searchMaterialReceiveByMaterialId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("materialReceive/update_note")
    @ResponseBody
    public ResponseVo update_note(Material_receive material_receive){
        ResponseVo responseVo = materialReceiveService.updateMaterialReceiveNote(material_receive);
        return responseVo;
    }

    @RequestMapping("materialReceive/add")
    public String add(){
        return "/WEB-INF/jsp/materialReceive_add.jsp";
    }

    @RequestMapping("materialReceive/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("materialReceive/insert")
    @ResponseBody
    public ResponseVo insert(Material_receive material_receive){
        ResponseVo responseVo = materialReceiveService.insertMaterialReceive(material_receive);
        return responseVo;
    }

    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }


    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = materialReceiveService.batchDeleteMaterialReceiveByIds(Arrays.asList(ids));
        return responseVo;
    }
}
