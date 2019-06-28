package com.cskaoyan.controller;

import com.cskaoyan.tool.FileUploadUtils;
import com.cskaoyan.vo.FileUploadVo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {


    @RequestMapping("pic/upload")
    @ResponseBody
    public FileUploadVo upload(String dir, HttpServletRequest request){
        Map<String, Object> map = FileUploadUtils.parseRequest(request, dir);
        FileUploadVo filevo = new FileUploadVo();
        String uploadFile = map.get("uploadFile").toString().substring(8);
        filevo.setUrl(uploadFile);
        return filevo;
    }
    @RequestMapping("file/upload")
    @ResponseBody
    public FileUploadVo fileupload(HttpServletRequest request){
        Map<String, Object> map = FileUploadUtils.parseRequest(request, "file");
        FileUploadVo filevo = new FileUploadVo();
        String uploadFile = map.get("file").toString().substring(8);
        filevo.setUrl(uploadFile);
        return filevo;
    }

    @RequestMapping("file/delete")
    @ResponseBody
    public HashMap filedelete(String fileName){
        String fullName = fileName.substring(23);
        FileUploadUtils.deleteFile(fullName);
        HashMap<String,Object> map = new HashMap<>();
        map.put("data","success");
        return map;
    }

    @RequestMapping("pic/delete")
    @ResponseBody
    public HashMap picdelete(String picName){
        FileUploadUtils.deleteFile(picName);

        HashMap<String,Object> map = new HashMap<>();
        map.put("data","success");
        return map;
    }
}
