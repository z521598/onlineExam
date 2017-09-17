package com.baidu.exam.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
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
    public String home(HttpSession session) {
        return "home.html";
    }

    // 用户登录
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpSession session, HttpServletResponse response) throws IOException {
        ResultBean resultBean = new ResultBean();
        boolean flag = false;
        String message = null;
        try {
            User loginUser = userService.login(user);
            if (loginUser != null) {
                session.setAttribute("loginUser", loginUser);
                response.sendRedirect("/home.html");
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

    // 管理员登录
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public String regist(User user, HttpSession session, HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        boolean flag = false;
        String message = null;
        try {
            if (user.getUsername().equals(Constant.ADMIN_USERNAME) && user.getPassword()
                    .equals(Constant.ADMIN_PASSWORD)) {
                session.setAttribute(Constant.USER_SESSION_ATTRIBUTE, user);
                response.sendRedirect("/admin/adminManage.html");
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
