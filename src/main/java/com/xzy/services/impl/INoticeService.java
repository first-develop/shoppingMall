package com.xzy.services.impl;

import com.xzy.model.Notice;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface INoticeService {
    public int addNotice(Notice notice);
   // public Notice deleteNoticeSelect(Model model);
    public Notice selectANotice(ModelAndView model, Integer id);
  //  public int deleteNotice(Integer id);


    public List<Notice> selectAllNotice();
}
