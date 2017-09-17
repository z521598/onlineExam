package com.baidu.exam.bean;

import java.util.List;

import com.baidu.exam.module.Question;

/**
 * Created by langshiquan on 17/9/13.
 */
public class PaperBean {
    private String title;
    private String author;
    private List<Question> questions;

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

    @Override
    public String toString() {
        return "PaperBean{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", questions=" + questions +
                '}';
    }
}
