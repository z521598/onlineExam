package com.baidu.exam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.exam.bean.ExamBean;
import com.baidu.exam.dao.AnswerDao;
import com.baidu.exam.dao.ExamDao;
import com.baidu.exam.dao.PaperDao;
import com.baidu.exam.dao.QuestionDao;
import com.baidu.exam.dao.UserDao;
import com.baidu.exam.module.Answer;
import com.baidu.exam.module.Exam;
import com.baidu.exam.module.ExamStatus;
import com.baidu.exam.module.Paper;
import com.baidu.exam.module.Question;
import com.baidu.exam.service.impl.ExamService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PaperDao paperDao;

    @Override
    public void dealExam(ExamBean examBean) {
        List<Answer> answers = examBean.getAnswers();
        Double totalMark = 0.0;
        // 判断分数
        for (Answer answer : answers) {
            // 获取答案
            Question question = questionDao.getOne(answer.getQuestionId());
            String answerStr = question.getAnswer();
            String[] keyWord = answerStr.split(" ");
            int times = 0;

            for (int i = 0; i < keyWord.length; i++) {
                if (answer.getContent().contains(keyWord[i])) {
                    times++;
                }
            }
            Double mark = ((double) times / (double) keyWord.length) * question.getMark();
            totalMark += mark;
            answer.setMark(mark);
        }
        Exam exam = new Exam();
        exam.setPaperId(examBean.getPaperId());
        exam.setEndTime(new Date());
        exam.setExamStatus(ExamStatus.DONE);
        exam.setTotalMark(totalMark);
        exam.setUserId(examBean.getUserId());
        examDao.save(exam);
        // 保存Answer
        Long examId = exam.getId();
        for (Answer answer : answers) {
            answer.setExamId(examId);
            answer.setUserId(examBean.getUserId());
            answerDao.save(answer);
        }
    }

    @Override
    public List<ExamBean> get(Long id) {
        List<ExamBean> list = new ArrayList<>();
        if (id == 0l) {
            List<Exam> exams = examDao.findAll();
            for (Exam exam : exams) {
                list.add(getOne(exam.getId()));
            }
        } else {
            list.add(getOne(id));
        }
        return list;
    }

    private ExamBean getOne(Long id) {
        ExamBean examBean = new ExamBean();
        Exam exam = examDao.findOne(id);
        examBean.setUserId(exam.getUserId());
        examBean.setPaperId(exam.getPaperId());
        examBean.setTotalMark(exam.getTotalMark());
        examBean.setName(userDao.findOne(exam.getUserId()).getName());
        Paper paper = paperDao.findOne(exam.getPaperId());
        examBean.setPaper(paper);
        examBean.setQuestions(questionDao.findByPaperId(exam.getPaperId()));
        examBean.setAnswers(answerDao.findByExamId(exam.getId()));
        return examBean;
    }

    @Override
    public void delete(Long id) {
        Exam exam = examDao.findOne(id);
        List<Answer> answers = answerDao.findByExamId(exam.getId());
        for (Answer answer : answers) {
            answerDao.delete(answer);
        }
    }
}
