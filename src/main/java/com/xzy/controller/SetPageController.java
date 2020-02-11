package com.xzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.User;
import com.xzy.services.MyPageSetService;
import com.xzy.utils.FileUpload;
import com.xzy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class SetPageController {
    @Autowired
    private MyPageSetService ms;

    //显示用户信息
    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest httpServletRequest) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        String userName = user.getUserName();
        String userEmail = user.getEmail();
        String userPic = user.getUserPic();

        String[] userMessage= new String[]{userName,userEmail,userPic};
        return JSONObject.toJSONString(userMessage);
    }

    //修改用户信息
    @RequestMapping("/setUser")
    public void setUser(String userName, String email, CommonsMultipartFile userPic, HttpServletRequest hq, HttpServletResponse hp) throws Exception {

        User user = (User) hq.getSession().getAttribute("user");
        int userId = user.getUserId();
        String fileName = userPic.getOriginalFilename();//获取图片名称
        String filePath = hq.getSession().getServletContext().getRealPath("img/")+fileName;//获取图片路径
        userPic.transferTo(new File(filePath));//保存图片
        //上传代码
        String url = FileUpload.upload(filePath);

        Map map = new HashMap();
        map.put("userName",userName);
        map.put("email",email);
        map.put("userPic",url);
        map.put("userId",userId);

        ms.SetUser(map);
    }

    //修改密码
    @RequestMapping("/setpwd")
    public void setPwd(HttpServletRequest hq, HttpServletResponse hp, Model md) throws Exception {

      String oldPwd = MD5Utils.MD5Encode(hq.getParameter("oldPwd"),"UTF-8");
      String newPwd = MD5Utils.MD5Encode(hq.getParameter("newPwd"),"UTF-8");

      User user = (User) hq.getSession().getAttribute("user");
      int userId = user.getUserId();

      Map map = new HashMap();

      if(ms.CheckPwd(oldPwd) != null){
          map.put("userPwd",newPwd);
          map.put("userId",userId);
          ms.SetPwd(map);
      }else {
          md.addAttribute("error","原密码错误");
      }


    }
}
