package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(HttpSession httpSession) {
        //测试用  添加权限 正式版本删除下面五句
        List<String> rootPermissionList = Arrays.asList( "order:add","order:edit","order:delete","custom:add","custom:edit","custom:delete","product:add","product:edit","product:delete","department:add","department:edit","department:delete","employee:add","employee:edit","employee:delete","work:add","work:edit","work:delete","manufacture:add","manufacture:edit","manufacture:delete","task:add","task:edit","task:delete","technology:add","technology:edit","technology:delete","process:add","process:edit","process:delete","technologyPlan:add","technologyPlan:edit","technologyPlan:delete","technologyRequirement:add","technologyRequirement:edit","technologyRequirement:delete","fCountCheck:add","fCountCheck:edit","fCountCheck:delete","fMeasureCheck:add","fMeasureCheck:edit","fMeasureCheck:delete","pCountCheck:add","pCountCheck:edit","pCountCheck:delete","pMeasureCheck:add","pMeasureCheck:edit","pMeasureCheck:delete","unqualify:add","unqualify:edit","unqualify:delete","material:add","material:edit","material:delete","materialReceive:add","materialReceive:edit","materialReceive:delete","user:add","user:edit","user:delete","role:add","role:edit","materialConsume:add","materialConsume:edit","materialConsume:delete","device:add","device:edit","device:delete","deviceCheck:add","deviceCheck:edit","deviceCheck:delete","deviceFault:add","deviceFault:edit","deviceFault:delete","deviceMaintain:add","deviceMaintain:edit","deviceMaintain:delete","deviceType:add","deviceType:edit","deviceType:delete");
        HashMap<String, String> map = new HashMap<>();
	map.put("rolename","超级管理员");
	httpSession.setAttribute("activeUser",map);
        httpSession.setAttribute("sysPermissionList",rootPermissionList);
        return "/WEB-INF/jsp/home.jsp";
    }

}
