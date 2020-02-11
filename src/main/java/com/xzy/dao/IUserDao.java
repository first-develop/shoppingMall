package com.xzy.dao;

import com.xzy.model.User;

import java.util.List;

public interface IUserDao {

    //根据id查询用户信息
    public User selectUser(long id);
    //查询用户信息
    public List<User> selectUsers(User user);
    //修改用户信息
    public int update(User user);
    //添加用户信息
    public int insert(User user);
    //删除用户信息
    public int delete(int userid);
}

