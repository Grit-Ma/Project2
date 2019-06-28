package com.cskaoyan.controller;

import com.cskaoyan.tool.FileUploadUtils;
import com.cskaoyan.vo.FileUploadVo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
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

    @RequestMapping("tttt")
    public String  findUpload(HttpServletRequest request) throws MalformedURLException {
        String servletPath = request.getServletPath();
        String ret = "WEB-INF/" + servletPath;
        System.out.println(ret);
        return "WEB-INF/upload/image/4/7/6/5/1/8/7/7/f3292f9a-ce23-4459-8d7c-444d9db73ab4.jpg";
    }
}
