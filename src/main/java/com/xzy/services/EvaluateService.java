package com.xzy.services;

import com.xzy.vo.Evaluatevo;

import java.util.List;
import java.util.Map;

public interface EvaluateService {

    //查询总评价数
    long count(int gid);

    //查询订单状态
    int getOrderState(int oid);

    //查询商品id,用户id
    int getGid(int oid);

    //插入评论
    void setEvaluate(Map map) throws Exception;

    //查询商品所有评论
    public List<Evaluatevo> getalleva(int goodsId);
}
