package com.xzy.services.impl;
/**
 * impl处于controller层的services下，用来存放接口的实现类，impl的全称为implement，表示实现的意思。
 */

import com.xzy.dao.IUserDao;
import com.xzy.model.User;
import com.xzy.services.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }

    @Override
    public User get(long user_ID) {
        User user = new User();
        user.setUser_ID(user_ID);
        List<User> users = userDao.getall();
        for (User u:users) {
            System.out.println("id"+u.getUser_ID()+"name"+u.getUser_name()+"pwd"+u.getUser_pwd());
            System.out.print(u.toString());
        }

        return userDao.get(user);
    }

    @Override
    public List<User> showall() {
        List<User> users = userDao.getall();
        for (User u:users) {
            System.out.println("id"+u.getUser_ID()+"name"+u.getUser_name()+"pwd"+u.getUser_pwd());
            System.out.print(u.toString());
        }
        return users;
    }


}
