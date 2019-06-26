package com.cskaoyan.service;

import com.cskaoyan.bean.Sys_user;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    Sys_user queryUserById(String id);
    List<Sys_user> queryUsers();
    HashMap<String,Object> getJson(int page, int rows);
}
