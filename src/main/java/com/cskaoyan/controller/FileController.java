package com.cskaoyan.controller;

import com.cskaoyan.tool.FileUploadUtils;
import com.cskaoyan.vo.FileUploadVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class FileController {


    @RequestMapping("pic/upload")
    @ResponseBody
    public FileUploadVo upload(MultipartFile uploadFile) throws IOException {
        String url = FileUploadUtils.uploadFile(uploadFile, "pic");
        FileUploadVo vo = new FileUploadVo();
        vo.setUrl(url);
        return vo;
    }


    @RequestMapping("file/upload")
    @ResponseBody
    public FileUploadVo tfileupload(MultipartFile file) throws IOException {
        FileUploadUtils.uploadFile(file,"file");
        return new FileUploadVo();
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
