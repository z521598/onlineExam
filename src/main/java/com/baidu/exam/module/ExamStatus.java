package com.baidu.exam.module;

/**
 * Created by langshiquan on 17/9/17.
 */
public enum ExamStatus {
    INIT("初始化"), DOING("进行中"), DONE("已结束");

    private String value;

    ExamStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
