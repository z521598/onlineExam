package com.baidu.exam.service.impl;

import com.baidu.exam.bean.PaperBean;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface PaperService {

    boolean savePaperAndQuestion(PaperBean paperBean);

    PaperBean assemblePaperAndQuestion(Long paperId);

    void deletePaperAndQuestion(Long paperId);
}
