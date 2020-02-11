package com.xzy.services.impl;
/**
 * impl处于controller层的services下，用来存放接口的实现类，impl的全称为implement，表示实现的意思。
 */

import com.xzy.dao.IUserDao;
import com.xzy.model.User;
import com.xzy.services.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService") //表示这是一个业务层，是service类 @controller是用于标注控制层组件，@Component是当某一个类不好归类的时候用 这个注解
public class UserServiceImpl implements IUserService {

    @Resource //自动转载，根据名称注入
    private IUserDao userDao;

    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }

    @Override
    public User getselectUser(long userId) {
        User user=userDao.selectUser(userId);
        return user;
    }

    @Override
    public List<User> getselectUsers(User user) {
            List<User> users=userDao.selectUsers(user);
        return users;
}

    @Override
    public String getupdate(User user) {
        //调dao里面的方法
        int u=userDao.update(user);
        String message="";
        if(u>0){
            message="修改成功";
        }else{
            message="修改失败";
        }

        return message;
    }

    @Override
    public String getinsert(User user) {
        //调dao里面的方法
        int u=userDao.insert(user);
        String message="";
        if(u>0){
            message="插入成功";
        }else{
            message="插入失败";
        }

        return message;
    }

    @Override
    public String getdelete(int userid) {
        //调dao里面的方法
        int u=userDao.delete(userid);
        String message="";
        if(u>0){
            message="删除成功";
        }else{
            message="删除失败";
        }
        return message;
    }
}