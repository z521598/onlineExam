package com.baidu.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.exam.dao.NoticeDao;
import com.baidu.exam.module.Notice;
import com.baidu.exam.service.impl.NoticeService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public void save(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void delete(Long id) {
        noticeDao.delete(id);
    }

    @Override
    public List<Notice> getNotice(Long id) {
        List<Notice> notices = new ArrayList<>();
        if (id == 0l) {
            notices = noticeDao.findAll();
        } else {
            notices.add(noticeDao.findOne(id));
        }

        return notices;
    }
}
