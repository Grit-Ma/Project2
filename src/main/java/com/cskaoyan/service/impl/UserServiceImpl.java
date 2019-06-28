package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Sys_user;
import com.cskaoyan.bean.Sys_userExample;
import com.cskaoyan.mapper.Sys_userMapper;
import com.cskaoyan.service.UserService;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PageVo getPage(int page, int rows) {
        List<Sys_user> users = queryUsers();
        PageVo pages = PageTool.getPageVo(users, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateUser(Sys_user user) {
        ResponseVo responseVo = new ResponseVo();
        try{
            int res = userMapper.updateByPrimaryKey(user);
            responseVo.setMsg("修改成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("修改失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo insertUser(Sys_user user) {
        ResponseVo responseVo = new ResponseVo();
        try{
            int res = userMapper.insert(user);
            responseVo.setMsg("新增成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("新增失败:"+e.getMessage());
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public ResponseVo batchDeleteUserByIds(List<String> ids) {
        ResponseVo responseVo = new ResponseVo();
        Sys_userExample example = new Sys_userExample();
        Sys_userExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        try{
            userMapper.deleteByExample(example);
            responseVo.setMsg("删除成功");
            responseVo.setStatus(200);
        }catch (Exception e){
            responseVo.setMsg("删除失败");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

    @Override
    public PageVo searchUserByUserId(String searchValue, int page, int rows) {
        Sys_userExample example = new Sys_userExample();
        Sys_userExample.Criteria criteria = example.createCriteria();
        criteria.andIdLike("%"+searchValue+"%");
        List<Sys_user> users = userMapper.selectByExample(example);
        PageVo pageVo = PageTool.getPageVo(users, page, rows);
        return pageVo;
    }

    //TODO 使用AOP重构
    @Override
    public PageVo searchUserByUserName(String searchValue, int page, int rows) {
        Sys_userExample example = new Sys_userExample();
        Sys_userExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike("%"+searchValue+"%");
        List<Sys_user> users = userMapper.selectByExample(example);
        PageVo pageVo = PageTool.getPageVo(users, page, rows);
        return pageVo;
    }


}
