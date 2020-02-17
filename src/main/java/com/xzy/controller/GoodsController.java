package com.xzy.controller;


import com.xzy.model.goods_table;
import com.xzy.model.goods_tableVO;
import com.xzy.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
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

    @RequestMapping("/search2")
    public ModelAndView search2(@RequestParam(required = false) String key){

        List<goods_tableVO>  goods_tableVOList=searchService.search2(key);
        ModelAndView mav=new ModelAndView("searchgoods2");
        mav.addObject("goodslist",goods_tableVOList);
        return mav;

    }


}
