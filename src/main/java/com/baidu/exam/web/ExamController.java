package com.baidu.exam.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baidu.exam.bean.ExamBean;
import com.baidu.exam.bean.PaperBean;
import com.baidu.exam.bean.ResultBean;
import com.baidu.exam.common.Constant;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.ExamService;

/**
 * Created by langshiquan on 17/9/17.
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
    private final static Logger LOG = LoggerFactory.getLogger(ExamRESTfulController.class);

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody ExamBean examBean, HttpSession session) {
        ResultBean resultBean = new ResultBean();
        try {
            examBean.setUserId(((User) session.getAttribute(Constant.USER_SESSION_ATTRIBUTE)).getId());
            examService.dealExam(examBean);
        } catch (Exception e) {
            resultBean.setSuccess(false);
            resultBean.setMessage(e.getMessage());
        }
        return JSON.toJSONString(resultBean);
    }

    // 如果是0，则查所有
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable Long id) {
        List<ExamBean> examBeanList = examService.get(id);
        return JSON.toJSONString(examBeanList);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        examService.delete(id);
        return JSON.toJSONString(new ResultBean());
    }
}
