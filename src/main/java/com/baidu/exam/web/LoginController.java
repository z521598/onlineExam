package com.baidu.exam.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baidu.exam.module.User;

/**
 * Created by langshiquan on 17/6/12.
 */
@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String home() {
        LOG.info("hello");
        return "home.html";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(User user) {

        return "";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String regist(User user) {

        return "";
    }

}
