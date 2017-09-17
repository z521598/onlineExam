package com.baidu.exam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.exam.bean.PaperBean;
import com.baidu.exam.dao.PaperDao;
import com.baidu.exam.dao.QuestionDao;
import com.baidu.exam.module.Paper;
import com.baidu.exam.module.Question;
import com.baidu.exam.service.impl.PaperService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDao paperDao;

    @Autowired
    QuestionDao questionDao;

    @Override
    public boolean savePaperAndQuestion(PaperBean paperBean) {
        Double totalMark = 0.0;
        List<Question> list = paperBean.getQuestions();
        // 计算总分数
        for (Question question : list) {
            totalMark += question.getMark();
        }
        Paper paper = new Paper();
        paper.setAuthor(paperBean.getAuthor());
        paper.setTime(new Date());
        paper.setTitle(paperBean.getTitle());
        paper.setTotalMark(totalMark);
        paperDao.save(paper);
        // 保存Question
        for (Question question : list) {
            question.setPaperId(paper.getId());
            questionDao.save(question);
        }
        return true;

    }

    @Override
    public List<PaperBean> assemblePaperAndQuestionList(Long paperId) {
        List<PaperBean> paperBeanList = new ArrayList<>();
        if (paperId == 0) {
            List<Paper> papers = paperDao.findAll();
            for (Paper paper : papers) {
                paperBeanList.add(assemblePaperAndQuestion(paper.getId()));
            }
        } else {
            paperBeanList.add(assemblePaperAndQuestion(paperId));
        }
        return paperBeanList;
    }

    private PaperBean assemblePaperAndQuestion(Long paperId) {
        PaperBean paperBean = new PaperBean();
        Paper paper = paperDao.findOne(paperId);
        paperBean.setTitle(paper.getTitle());
        paperBean.setAuthor(paper.getAuthor());
        List<Question> questionList = questionDao.findByPaperId(paperId);
        paperBean.setQuestions(questionList);
        return paperBean;
    }

    @Override
    public void deletePaperAndQuestion(Long paperId) {
        List<Question> list = questionDao.findByPaperId(paperId);
        for (Question question : list) {
            questionDao.delete(question);
        }
        paperDao.delete(paperId);
    }
}
