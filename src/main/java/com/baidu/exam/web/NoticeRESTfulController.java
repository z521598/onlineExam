package com.baidu.exam.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baidu.exam.bean.ResultBean;
import com.baidu.exam.module.Notice;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.NoticeService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Controller
@RequestMapping("/notice")
public class NoticeRESTfulController extends BaseController {

    private final static Logger LOG = LoggerFactory.getLogger(NoticeRESTfulController.class);
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String add(Notice notice) {
        LOG.info("come a add notice ,msg:{}", notice);
        noticeService.save(notice);
        return JSON.toJSONString(new ResultBean());
    }

    // 如果是0，则查所有
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable Long id) {
        return JSON.toJSONString(noticeService.getNotice(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        return JSON.toJSONString(new ResultBean());
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public String update(Notice notice) {
        noticeService.save(notice);
        return JSON.toJSONString(new ResultBean());
    }

}
