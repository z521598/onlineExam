package com.baidu.exam.service.impl;

import java.util.List;

import com.baidu.exam.bean.PaperBean;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface PaperService {

    boolean savePaperAndQuestion(PaperBean paperBean);

    List<PaperBean> assemblePaperAndQuestionList(Long paperId);

    void deletePaperAndQuestion(Long paperId);
}
