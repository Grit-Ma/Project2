package com.cskaoyan.controller;

import com.cskaoyan.tool.FileUploadUtils;
import com.cskaoyan.vo.FileUploadVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FileController {


    @RequestMapping("pic/upload")
    @ResponseBody
    public FileUploadVo upload(String dir, HttpServletRequest request){
        Map<String, Object> map = FileUploadUtils.parseRequest(request, dir);
        FileUploadVo filevo = new FileUploadVo();
        String uploadFile = map.get("uploadFile").toString().substring(15);
        filevo.setUrl(uploadFile);
        return filevo;
    }
}
