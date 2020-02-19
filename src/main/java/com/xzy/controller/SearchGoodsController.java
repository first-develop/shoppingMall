package com.xzy.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xzy.model.User;
import com.xzy.model.goods_table;
import com.xzy.model.goods_tableVO;
import com.xzy.services.SearchService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/goods")
public class SearchGoodsController {
    @Resource
    SearchService searchService;

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String key){
        List<goods_table> goods_tableList=searchService.search(key);
        ModelAndView mav=new ModelAndView();
        mav.addObject("goodslist",goods_tableList);
        mav.setViewName("searchgoods");
        return mav;
    }

    //搜索并写入搜索记录
    @RequestMapping("/search2")
    public ModelAndView search2(@RequestParam(required = false) String key, HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");
        if (user!=null)
        {
            Jedis jedis=new Jedis();
            jedis.sadd(Long.toString(user.getUser_ID()),key);
        }
        List<goods_tableVO>  goods_tableVOList=searchService.search2(key);
        ModelAndView mav=new ModelAndView("searchgoods2");
        mav.addObject("goodslist",goods_tableVOList);
        return mav;
    }


//显示搜索记录
    @RequestMapping("/searchkey")
    public ModelAndView searchkey(HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");

        ModelAndView mav=new ModelAndView("searchkey");
        if (user!=null)
        {
            Jedis jedis=new Jedis();
            List searchkey=  jedis.srandmember(Long.toString(user.getUser_ID()),10);
            mav.addObject(Long.toString(user.getUser_ID()),searchkey);
            return  mav;
        }
        return  mav;
    }


//删除搜索记录
    @RequestMapping("/searchkeydel")
    public void searchkeydel(HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");
        if (user!=null){
            Jedis jedis=new Jedis();
            jedis.del(Long.toString(user.getUser_ID()));
        }
    }


}
