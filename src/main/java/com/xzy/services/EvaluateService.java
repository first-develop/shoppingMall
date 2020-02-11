package com.xzy.services;

import com.xzy.model.Evaluate;
import com.xzy.model.OrderUser;

import java.util.Map;

public interface EvaluateService {
    //当前商品评价
    Evaluate findPage(int gid);

    //查询总评价数
    long count(int gid);

    //查询订单状态
    int getOrderState(int oid);

    //查询商品id,用户id
    OrderUser getUGid(int oid);

    //插入评论
    void inEvaluate(Map map);
}
