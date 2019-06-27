package com.cskaoyan.service;

import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserService {
    Sys_user queryUserById(String id);
    List<Sys_user> queryUsers();
    PageVo getPage(int page, int rows);
    ResponseVo updateUser(Sys_user user);
    ResponseVo insertUser(Sys_user user);
    @Delete("delete from ")
    ResponseVo batchDeleteUserByIds(List<String> ids);
}
