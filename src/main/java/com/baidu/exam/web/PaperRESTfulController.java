package com.baidu.exam.web;

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
import com.baidu.exam.bean.PaperBean;
import com.baidu.exam.bean.ResultBean;
import com.baidu.exam.service.impl.PaperService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Controller
@RequestMapping("/paper")
public class PaperRESTfulController extends BaseController{

    public final static Logger LOG = LoggerFactory.getLogger(UserRESTfulController.class);

    @Autowired
    PaperService paperService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody PaperBean paper) {
        ResultBean resultBean = new ResultBean();
        try {
            paperService.savePaperAndQuestion(paper);
        } catch (Exception e) {
            resultBean.setSuccess(false);
            resultBean.setMessage(e.getMessage());
        } finally {
            return JSON.toJSONString(resultBean);
        }

    }

    // 如果是0，则查所有
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable Long id) {
        return JSON.toJSONString(paperService.assemblePaperAndQuestion(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        paperService.deletePaperAndQuestion(id);
        return JSON.toJSONString(new ResultBean());
    }
}
