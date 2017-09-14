package com.baidu.exam.module;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by langshiquan on 17/9/13.
 */
@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paperId;

    private Long userId;

    private Double totalMark;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", paperId=" + paperId +
                ", userId=" + userId +
                ", totalMark=" + totalMark +
                ", time=" + time +
                '}';
    }
}
