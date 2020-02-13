package com.xzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.User;
import com.xzy.services.EvaluateService;
import com.xzy.vo.Evaluatevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService em;

    @RequestMapping(value = "/showall",produces = {"application/json;charset=UTF-8"})
    public String findallEva(int gid){
        List<Evaluatevo> evaluatevosList=new ArrayList<Evaluatevo>();
        evaluatevosList=em.getalleva(gid);

        return JSONObject.toJSONString(evaluatevosList);
    }

    @RequestMapping("/upeveluate")
    public void upEveluate(String dialogbox, int orderId, HttpServletRequest hq, HttpServletResponse hp, Model md) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = (User) hq.getSession().getAttribute("user");
        int userId = user.getUserId();
        int orderState = em.getOrderState(orderId);
        int gid = em.getGid(orderId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        long comnum = em.count(gid);
        Map map = new HashMap();
        if(orderState == 1){
            if(dialogbox.isEmpty() || dialogbox.length()>200){
                md.addAttribute("error","评价为空或评价大于200字");
            }else {
                long num = comnum+1;
                map.put("dialogbox",dialogbox);
                map.put("userId",userId);
                map.put("gid",gid);
                map.put("date",formatter.format(date));
                map.put("num",num);
                em.setEvaluate(map);
                mv.setViewName("success");
            }
        }else{
            md.addAttribute("error","暂不能评价");
        }
    }

    @RequestMapping("/deleteEveluate")
    public void delete(){

    }

}
