package com.baidu.exam.bean;

import java.util.List;

import com.baidu.exam.module.Question;

/**
 * Created by langshiquan on 17/9/13.
 */
public class ExamBean {
    Long paperId;
    String name;
    Long userId;
    Double totalMark;
    List<Question> questions;

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ExamBean{" +
                "paperId=" + paperId +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}
