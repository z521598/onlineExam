package com.baidu.exam.common;

/**
 * Created by langshiquan on 17/9/17.
 */
public enum StatusEnum {
    INIT("初始化"), DOING("进行中"), DONE("已结束");

    private String value;

    StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
