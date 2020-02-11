package com.xzy.controller;

import com.xzy.model.Notice;
import com.xzy.services.impl.INoticeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@ResponseBody
@Controller
@RequestMapping("/message/notice")
public class NoticeController  {
    @Autowired
    private INoticeService noticeService;
    @RequestMapping("/toAddNotice")
    public String toAddNotice(Model model) {
        model.addAttribute("notice", new Notice());
        return "admin/addNotice";
    }
    @RequestMapping(value = "/addNotice")
    public int addNotice(@ModelAttribute Notice notice) {
        return noticeService.addNotice(notice);
    }
//    @RequestMapping("/deleteNoticeSelect")
//    public ModelAndView deleteNoticeSelect(Model model) {
//        ModelAndView mv = new ModelAndView();
//        Notice notice = noticeService.deleteNoticeSelect(model);
//        mv.addObject("deleteNoticeSelect", notice);
//        mv.setViewName("deleteNoticeSelect");
//     //   System.out.println(notice.getNcontent());
//        return mv;
//        //return noticeService.deleteNoticeSelect(model);
//    }

    @RequestMapping(value = "/select")
    public JSONObject selectUser(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Notice notice = noticeService.selectANotice(mv,2);
       // System.out.println(JSONObject.fromObject(notice));
        return JSONObject.fromObject(notice);

    }
//    @RequestMapping("/deleteNotice")
//    public int deleteNotice(Integer id) {
//        return noticeService.deleteNotice(id);
//    }

    @RequestMapping(value = "/selectallnotice")
    public JSONArray selectAllNotice(){

       List<Notice> notices= noticeService.selectAllNotice();
     System.out.println(JSONArray.fromObject(notices));
       return JSONArray.fromObject(notices);

    }
}
