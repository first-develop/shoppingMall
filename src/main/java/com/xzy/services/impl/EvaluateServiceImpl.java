package com.xzy.services.impl;

import com.xzy.dao.EvaluateMapper;
import com.xzy.model.Evaluate;
import com.xzy.model.OrderUser;
import com.xzy.services.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper em;

    @Override
    public Evaluate findPage(int gid) {
        return em.findPage(gid);
    }

    @Override
    public long count(int gid) {
        return em.count(gid);
    }

    @Override
    public int getOrderState(int oid) {
        return em.getOrderState(oid);
    }

    @Override
    public OrderUser getUGid(int oid) {
        return em.getUGid(oid);
    }

    @Override
    public void inEvaluate(Map map) {
        em.inEvaluate(map);
        System.out.println("评价成功");
    }
}
