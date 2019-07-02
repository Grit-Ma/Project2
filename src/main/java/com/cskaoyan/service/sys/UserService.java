package com.cskaoyan.service.sys;

import com.cskaoyan.bean.sys.SysUser;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface UserService {
    SysUser queryUserById(String id);
    List<SysUser> queryUsers();
    PageVo getPage(int page, int rows);
    ResponseVo updateUser(SysUser user);
    ResponseVo insertUser(SysUser user);
    @Delete("delete from ")
    ResponseVo batchDeleteUserByIds(List<String> ids);

    PageVo searchUserByUserId(String searchValue, int page, int rows);

    PageVo searchUserByUserName(String searchValue, int page, int rows);
}
