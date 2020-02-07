package com.xzy.services;

import com.xzy.model.User;

import java.util.List;

public interface IUserService {
    public User selectUser(long userId);
    public User get(long user_ID);
    List<User> showall();



}
