package com.cskaoyan.service.sys.impl;

import com.cskaoyan.bean.sys.SysUser;
import com.cskaoyan.bean.sys.SysUserExample;
import com.cskaoyan.mapper.sys.SysUserMapper;
import com.cskaoyan.service.sys.UserService;
import com.cskaoyan.tool.Cipher;
import com.cskaoyan.tool.PageTool;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper userMapper;

    @Override
    public SysUser queryUserById(String id) {
        SysUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<SysUser> queryUsers() {
        List<SysUser> sys_users = userMapper.selectByExample(new SysUserExample());
        return sys_users;
    }


    @Override
    public PageVo getPage(int page, int rows) {
        List<SysUser> users = queryUsers();
        PageVo pages = PageTool.getPageVo(users, page, rows);
        return pages;
    }

    @Override
    public ResponseVo updateUser(SysUser user) {
        ResponseVo responseVo = new ResponseVo();
        try{
            user.setPassword(Cipher.encode(user.getPassword()));
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
    public ResponseVo insertUser(SysUser user) {
        ResponseVo responseVo = new ResponseVo();
        try{
            user.setPassword(Cipher.encode(user.getPassword()));
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
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
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
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdLike("%"+searchValue+"%");
        List<SysUser> users = userMapper.selectByExample(example);
        PageVo pageVo = PageTool.getPageVo(users, page, rows);
        return pageVo;
    }

    //TODO 使用AOP重构
    @Override
    public PageVo searchUserByUserName(String searchValue, int page, int rows) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameLike("%"+searchValue+"%");
        List<SysUser> users = userMapper.selectByExample(example);
        PageVo pageVo = PageTool.getPageVo(users, page, rows);
        return pageVo;
    }


}
