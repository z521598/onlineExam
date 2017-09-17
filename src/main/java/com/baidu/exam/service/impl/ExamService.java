package com.baidu.exam.service.impl;

import java.util.List;

import com.baidu.exam.bean.ExamBean;
import com.baidu.exam.module.Exam;
import com.baidu.exam.module.User;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface ExamService {
    void dealExam(ExamBean examBean);

    List<ExamBean> getById(Long id);

    List<Exam> getByUser(User user);

    void delete(Long id);

}
