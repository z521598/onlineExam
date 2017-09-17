package com.baidu.exam.service.impl;

import java.util.List;

import com.baidu.exam.module.Notice;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface NoticeService {
    void save(Notice notice);

    void delete(Long id);

    List<Notice> getNotice(Long id);

}
