package com.cskaoyan.tool;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class FileUploadUtils {

    public static Map<String, Object> parseRequest(HttpServletRequest request,String dir) {
        Map<String,Object> mp = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            List<FileItem> items = upload.parseRequest(request);
            mp = buildMap(items,dir);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return mp;
    }

    private static Map<String,Object> buildMap(List<FileItem> items,String dir) {
        Map<String,Object> mp = new HashMap<>();
        Iterator<FileItem> iterator = items.iterator();
        FileItem fileItem = null;
        while (iterator.hasNext()) {
            FileItem item = iterator.next();
            if (item.isFormField()) {
                processFormField(mp,item);
            } else {
                fileItem = item;
            }
        }
        //保证文件最后处理
        processUploadFile(mp, fileItem,dir);
        return mp;
    }

    private static void processUploadFile(Map<String, Object> mp, FileItem item,String dir) {
        if(item == null ){
            return;
        }
        String fieldName = item.getFieldName();
        //获取项目根目录
        String rootPath = FileUploadUtils.class.getClassLoader().getResource("../..").getPath();
        StringBuilder uploadPath = new StringBuilder( "WEB-INF/upload/" + dir+"/");
        String fileName =  item.getName();
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        UUID uuid = UUID.randomUUID();
        String hashCode = fileName.hashCode()+"";
        char[] chars = hashCode.toCharArray();
        for (char c : chars) {
            uploadPath.append( c + "/");
        }
        if(!"file".equals(fieldName)) {
            fileName = uuid.toString() + suffix;
        }
        File uploadFile = new File(rootPath + uploadPath + fileName);
        if(!uploadFile.getParentFile().exists()){
            uploadFile.getParentFile().mkdirs();
        }
        try {
            item.write(uploadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mp.put(fieldName,uploadPath + fileName);
    }

    private static void processFormField(Map<String, Object> mp, FileItem item) {
        try {
            String fieldName = item.getFieldName();
            String value = item.getString("utf-8");
            mp.put(fieldName, value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fullName) {
        String rootPath = FileUploadUtils.class.getClassLoader().getResource("../..").getPath();
        String filePath = rootPath + "WEB-INF/" + fullName;
        File file = new File(filePath);
        file.delete();
    }
}
