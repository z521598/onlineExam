package com.baidu.exam.service.impl;

import java.util.List;

import com.baidu.exam.bean.ExamBean;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface ExamService {
    void dealExam(ExamBean examBean);

    List<ExamBean> get(Long id);

    void delete(Long id);
}
