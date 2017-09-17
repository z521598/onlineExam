package com.baidu.exam.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baidu.exam.bean.PaperForUserBean;
import com.baidu.exam.common.Constant;
import com.baidu.exam.module.Exam;
import com.baidu.exam.module.Paper;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.ExamService;
import com.baidu.exam.service.impl.PaperService;

/**
 * Created by langshiquan on 17/9/17.
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private PaperService paperService;

    @RequestMapping("/getExamOrPaperForUser")
    public String getExamOrPaperStatus(HttpSession session) {
        // 用于返回的结果
        List<PaperForUserBean> paperForUserBeanList = new ArrayList<>();
        // 获取全部试卷
        List<Paper> paperList = paperService.findAll();
        assemble(paperForUserBeanList, paperList);
        // 获取该用户参加过的所有考试
        List<Exam> exams = examService.getByUser((User) session.getAttribute(Constant.USER_SESSION_ATTRIBUTE));

        // 修改PaperForUserBean状态
        for (int i = 0; exams != null && i < exams.size(); i++) {
            for (int j = 0; paperForUserBeanList != null && j < paperForUserBeanList.size(); j++) {
                PaperForUserBean paperForUserBean = paperForUserBeanList.get(j);
                Exam exam = exams.get(i);
                if (paperForUserBean.getId() == exam.getPaperId()) {
                    paperForUserBean.setExamStatus(exam.getExamStatus());
                    paperForUserBean.setExamId(exam.getId());
                    paperForUserBean.setRealMark(exam.getTotalMark());
                }
            }
        }
        return JSON.toJSONString(paperForUserBeanList);
    }

    private void assemble(List<PaperForUserBean> paperForUserBeanList, List<Paper> paperList) {
        for (Paper paper : paperList) {
            paperForUserBeanList.add(new PaperForUserBean(paper));
        }
    }
}
