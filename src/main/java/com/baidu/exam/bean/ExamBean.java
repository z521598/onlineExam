package com.baidu.exam.bean;

import java.util.List;

import com.baidu.exam.module.Answer;
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
    private List<Answer> answers;
    private List<Question> questions;

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
        return answers;
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
