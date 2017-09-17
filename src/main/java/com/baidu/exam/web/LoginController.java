package com.baidu.exam.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baidu.exam.bean.ResultBean;
import com.baidu.exam.common.Constant;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.UserService;

/**
 * Created by langshiquan on 17/6/12.
 */
@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "home.html";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        //        ResultBean resultBean = new ResultBean();
        //        boolean flag = false;
        //        String message = null;
        //        try {
        if (userService.login(user)) {
            session.setAttribute("loginUser", user.getId());
            //                flag = true;
        }
        //            else {
        //                message = "账号或者密码错误";
        //            }
        //        } catch (Exception e) {
        //            message = "unkown reason:" + e.getMessage();
        //        }
        //        resultBean.setSuccess(flag);
        //        resultBean.setMessage(message);
        //        return JSON.toJSONString(resultBean);
        return "/";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String regist(User user, HttpSession session) {
        ResultBean resultBean = new ResultBean();
        boolean flag = false;
        String message = null;
        try {
            if (user.getUsername().equals(Constant.ADMIN_USERNAME) && user.getPassword()
                    .equals(Constant.ADMIN_PASSWORD)) {
                session.setAttribute(Constant.USER_SESSION_ATTRIBUTE, user);
                flag = true;
            } else {
                message = "账号或者密码错误";
            }
        } catch (Exception e) {
            message = "unkown reason:" + e.getMessage();
        }
        resultBean.setSuccess(flag);
        resultBean.setMessage(message);
        return JSON.toJSONString(resultBean);
    }

}
