package com.cskaoyan.controller.material;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.Material_consume;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.cskaoyan.service.material.MaterialService;
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
public class MaterialConsumeController {
    
    @Autowired
    MaterialConsumeService materialConsumeService;

    @Autowired
    MaterialService materialService;

    @RequestMapping("materialConsume/find")
    public String find(){
        return "/WEB-INF/jsp/materialConsume_list.jsp";
    }

    @RequestMapping("materialConsume/list")
    @ResponseBody
    public PageVo list(int page, int rows){
        PageVo pageVo = materialConsumeService.getPage(page, rows);
        return pageVo;
    }

    @RequestMapping("materialConsume/edit")
    public String edit(){
        return "/WEB-INF/jsp/materialConsume_edit.jsp";
    }

    @RequestMapping("materialConsume/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("materialConsume/update_all")
    @ResponseBody
    public ResponseVo update_all(Material_consume Material_consume){
        ResponseVo responseVo = materialConsumeService.updateMaterialConsume(Material_consume);
        return responseVo;
    }

    //search_materialConsume_by_consumeId
    @RequestMapping("materialConsume/search_materialConsume_by_consumeId")
    @ResponseBody
    public PageVo search_materialConsume_by_materialConsumeId(String searchValue, int page, int rows){
        PageVo pageVo = materialConsumeService.searchMaterialConsumeByConsumeId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("materialConsume/search_materialConsume_by_materialId")
    @ResponseBody
    public PageVo search_materialConsume_by_materialId(String searchValue, int page, int rows){
        PageVo pageVo = materialConsumeService.searchMaterialConsumeByMaterialId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("materialConsume/search_materialConsume_by_workId")
    @ResponseBody
    public PageVo search_materialConsume_by_workId(String searchValue, int page, int rows){
        PageVo pageVo = materialConsumeService.searchMaterialConsumeByWorkId(searchValue, page, rows);
        return pageVo;
    }

    @RequestMapping("materialConsume/update_note")
    @ResponseBody
    public ResponseVo update_note(Material_consume Material_consume){
        ResponseVo responseVo = materialConsumeService.updateMaterialConsumeNote(Material_consume);
        return responseVo;
    }

    @RequestMapping("materialConsume/add")
    public String add(){
        return "/WEB-INF/jsp/materialConsume_add.jsp";
    }

    @RequestMapping("materialConsume/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("materialConsume/insert")
    @ResponseBody
    public ResponseVo insert(Material_consume Material_consume){
        ResponseVo responseVo = materialConsumeService.insertMaterialConsume(Material_consume);
        return responseVo;
    }

    @RequestMapping("materialConsume/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }


    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        ResponseVo responseVo = materialConsumeService.batchDeleteMaterialConsumeByIds(Arrays.asList(ids));
        return responseVo;
    }

}
