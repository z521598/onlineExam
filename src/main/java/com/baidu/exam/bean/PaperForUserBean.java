package com.baidu.exam.bean;

import com.baidu.exam.module.ExamStatus;
import com.baidu.exam.module.Paper;

/**
 * Created by langshiquan on 17/9/17.
 */
public class PaperForUserBean extends Paper {
    private ExamStatus examStatus = ExamStatus.NO;

    private Long examId;

    private Double realMark;

    public PaperForUserBean(Paper paper) {
        super.setAuthor(paper.getAuthor());
        super.setTime(paper.getTime());
        super.setTitle(paper.getTitle());
        super.setTotalMark(paper.getTotalMark());
        super.setId(paper.getId());
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }

    public Double getRealMark() {
        return realMark;
    }

    public void setRealMark(Double realMark) {
        this.realMark = realMark;
    }

    @Override
    public String toString() {
        return "PaperForUserBean{" + super.toString() +
                "examStatus=" + examStatus +
                ", examId=" + examId +
                ", realMark=" + realMark +
                '}';
    }
}
