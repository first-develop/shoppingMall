package com.xzy.services.impl;

import com.xzy.dao.EvaluateMapper;
import com.xzy.model.Evaluate;
import com.xzy.model.User;
import com.xzy.services.EvaluateService;
import com.xzy.vo.Evaluatevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper em;

    @Override
    public List<Evaluatevo> getalleva(int goodsId) {
        List<Evaluatevo> evaluatevoList=new ArrayList<Evaluatevo>();

        List<com.xzy.model.Evaluate> evaluateList=em.findPage(goodsId);
        if(!evaluateList.isEmpty()){
            for (Evaluate evaluate :evaluateList) {
                Evaluatevo evaluatevo=new Evaluatevo();
                //查询头像和名字
                User user=em.getuser(evaluate.getUserId());
                evaluatevo.setDialogbox(evaluate.getDialogbox());
                evaluatevo.setDate(evaluate.getDate());
                evaluatevo.setUserName(user.getUserName());
                evaluatevo.setUserPic(user.getUserPic());
                evaluatevoList.add(evaluatevo);
            }
        }

        return evaluatevoList;
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
    public int getGid(int oid) {
        return em.getGid(oid);
    }

    @Override
    public void setEvaluate(Map map) throws Exception{
        em.setEvaluate(map);
        System.out.println("评价成功");
    }
}
