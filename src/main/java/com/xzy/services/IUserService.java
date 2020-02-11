package com.xzy.services;

import com.xzy.model.User;

import java.util.List;

public interface IUserService {
    //根据id查询
    public User getselectUser(long userId);
    //查询用户信息
    public List<User> getselectUsers(User user);
    //修改用户信息
    public String getupdate(User user);
    //添加用户信息
    public String getinsert(User user);
    //删除用户信息
    public String getdelete(int userid);
}
