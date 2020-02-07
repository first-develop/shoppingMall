package com.xzy.controller;

import com.xzy.model.User;
import com.xzy.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

   /* @RequestMapping("/select")
    public ModelAndView selectUser() throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = userService.selectUser(1);
        System.out.println(user.getUsername());
        mv.addObject("user", user);
        mv.setViewName("user");
        return mv;
    }*/
   //修改,先通过get方法得到一个对象
   @RequestMapping("editStudent")
   public ModelAndView editStudent(User user) {
       User  user1= userService.get(user.getUser_ID());
       System.out.println(user1.toString());
       ModelAndView mav = new ModelAndView("editStudent");
       mav.addObject("c",user1);
       return mav;
   }

}
