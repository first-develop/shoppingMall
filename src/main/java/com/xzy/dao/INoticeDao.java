package com.xzy.dao;

import com.xzy.model.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("adminNoticeDao")
public interface INoticeDao {
    public int addNotice(Notice notice);
    public List<Notice> deleteNoticeSelect();
   // public int deleteNotice(Integer id);
    public Notice selectANotice(Integer id);
    public List<Notice> selectAllNotice();

}
