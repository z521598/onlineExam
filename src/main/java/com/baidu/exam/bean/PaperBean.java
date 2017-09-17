package com.baidu.exam.bean;

import java.util.List;

import com.baidu.exam.module.Question;

/**
 * Created by langshiquan on 17/9/13.
 */
public class PaperBean {
    private Long paperId;
    private String title;
    private String author;
    private Double totalMark;
    private String allTime;
    private List<Question> questions;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    public Double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Double totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "PaperBean{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", questions=" + questions +
                '}';
    }
}
