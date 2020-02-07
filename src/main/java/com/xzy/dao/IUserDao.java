package com.xzy.dao;
import com.xzy.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface IUserDao {

    public  User selectUser(long id);

    public User get(User user);

    public List<User> getall();

}

