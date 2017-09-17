package com.baidu.exam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.exam.bean.ExamBean;
import com.baidu.exam.dao.ExamDao;
import com.baidu.exam.module.Exam;
import com.baidu.exam.module.ExamStatus;
import com.baidu.exam.module.Question;
import com.baidu.exam.service.impl.ExamService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Override
    public void dealExam(ExamBean examBean) {
        Exam exam = new Exam();
        exam.setPaperId(examBean.getPaperId());
        exam.setEndTime(new Date());
        exam.setExamStatus(ExamStatus.DONE);
        //        exam.setTotalMark();
        List<Question> questionList = examBean.getQuestions();
        for (Question question : questionList) {
           // TODO
        }
    }

    @Override
    public List<ExamBean> get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
