package com.xzy.dao;

import com.xzy.model.Evaluate;
import com.xzy.model.OrderUser;
import com.xzy.model.User;

import java.util.Map;

public interface EvaluateMapper {
    //所有评价
    Evaluate findPage(int gid);
    //查询总评价数
    long count(long gid);
    //查询订单状态
    int getOrderState(int oid);
    //查询商品id,用户id
    OrderUser getUGid(int oid);
    //插入评论
    void inEvaluate(Map map);
    //用户头像
    User getUPic(int uid);
}