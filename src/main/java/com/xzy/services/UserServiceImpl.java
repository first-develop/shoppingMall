package com.xzy.services;
/**
 * impl处于controller层的services下，用来存放接口的实现类，impl的全称为implement，表示实现的意思。
 */

import com.xzy.dao.IUserDao;
import com.xzy.model.User;
import com.xzy.services.impl.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(1);
    }
}