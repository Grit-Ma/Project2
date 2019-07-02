package com.cskaoyan.tool;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public class FileUploadUtils {

    public static void deleteFile(String fullName) {
        String rootPath = FileUploadUtils.class.getClassLoader().getResource("../..").getPath();
        String filePath = rootPath + "WEB-INF/" + fullName;
        File file = new File(filePath);
        file.delete();
    }

    public static String uploadFile(MultipartFile file,String dir) throws IOException {
        if(file == null)
            return "";
        String fileName = file.getOriginalFilename();
        String rootPath = FileUploadUtils.class.getClassLoader().getResource("../..").getPath();
        StringBuilder uploadPath = new StringBuilder( "WEB-INF/upload/" + dir+"/");
        File directory = new File(rootPath,uploadPath.toString());
        if(!directory.exists()){
            directory.mkdirs();
        }
        File myfile = new File(rootPath+uploadPath.toString(),fileName);
        file.transferTo(myfile);
        return uploadPath.substring(8) + fileName;
    }
}
