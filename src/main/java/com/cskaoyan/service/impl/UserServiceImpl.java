package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.bean.Sys_userExample;
import com.cskaoyan.mapper.Sys_userMapper;
import com.cskaoyan.service.UserService;
import com.cskaoyan.tool.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    Sys_userMapper userMapper;

    @Override
    public Sys_user queryUserById(String id) {
        Sys_user user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<Sys_user> queryUsers() {
        List<Sys_user> sys_users = userMapper.selectByExample(new Sys_userExample());
        return sys_users;
    }


    @Override
    public HashMap<String, Object> getJson(int page, int rows) {
        HashMap<String, Object> map = new HashMap<>();
        List<Sys_user> users = userMapper.selectByExample(new Sys_userExample());
        List<Sys_user> list = PageTool.getPagedData(users,page,rows);
        map.put("total",users.size());
        map.put("rows",list);
        return map;
    }


}
