package com.baidu.exam.bean;

/**
 * Created by langshiquan on 17/9/15.
 */
public class ResultBean {
    private Boolean isSuccess;
    private String message = "succ";

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                '}';
    }
}
