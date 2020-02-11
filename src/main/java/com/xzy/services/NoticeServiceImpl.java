package com.xzy.services;

import com.xzy.dao.INoticeDao;
import com.xzy.model.Notice;
import com.xzy.services.impl.INoticeService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
//@Transactional
public class NoticeServiceImpl implements INoticeService {
    //@Autowired
    @Resource
    private INoticeDao noticeDao;
    @Override
    public int addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
        //return "forward:/adminNotice/deleteNoticeSelect";
    }

//    @Override
//    public Model deleteNoticeSelect(Model model) {
//        return model.addAttribute("allNotice", noticeDao.deleteNoticeSelect());
//       // return "admin/deleteNoticeSelect";
//    }

    @Override
    public Notice selectANotice(ModelAndView model, Integer id) {


        return noticeDao.selectANotice(1);


    }

    @Override
    public List<Notice> selectAllNotice() {
        return noticeDao.selectAllNotice();
    }

//    @Override
//    public int deleteNotice(Integer id) {
//        return  noticeDao.deleteNotice(id);
//
//    }

//    @Override
//    public String selectAllNotice() {
//      return noticeDao.selectAllNotice();
//    }

}
