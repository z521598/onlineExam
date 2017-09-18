package com.baidu.exam.bean;

import java.util.ArrayList;
import java.util.List;

import com.baidu.exam.module.Answer;
import com.baidu.exam.module.ExamStatus;
import com.baidu.exam.module.Paper;
import com.baidu.exam.module.Question;

/**
 * Created by langshiquan on 17/9/13.
 */
public class ExamBean {
    private Long paperId;
    private String name;
    private Long userId;
    private Double totalMark;
    private Paper paper;
    private ExamStatus examStatus;
    private List<Long> questionId;
    private List<String> contents;
    private List<Answer> answers;
    private List<Question> questions;

    public List<Long> getQuestionId() {
        return questionId;
    }

    public void setQuestionId(List<Long> questionId) {
        this.questionId = questionId;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Double totalMark) {
        this.totalMark = totalMark;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        List<Answer> answerList = answers;
        if (answerList == null) {
            answerList= new ArrayList<>();
            for (int i = 0; questionId != null && i < questionId.size(); i++) {
                Answer answer = new Answer();
                answer.setQuestionId(questionId.get(i));
                answer.setContent(contents.get(i));
            }
        }
        return answerList;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "ExamBean{" +
                "paperId=" + paperId +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", totalMark=" + totalMark +
                ", answers=" + answers +
                '}';
    }
}
