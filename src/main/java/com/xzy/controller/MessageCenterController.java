package com.xzy.controller;

import com.xzy.pojo.Orders;
import com.xzy.services.impl.IMessageCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orderuser")
public class MessageCenterController {
    @Autowired
    private IMessageCenterService ordersService;
   // private UserController OrderUserService;

    @RequestMapping("/selectOrder")
    public ModelAndView selectOrder( long userid) throws Exception {
        ModelAndView mv = new ModelAndView();
       // long userId = userid;
        Orders orders = ordersService.selectOrders(userid);
        mv.addObject("orders", orders);
        mv.setViewName("orders");
        return mv;
    }

}
