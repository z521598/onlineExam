package com.baidu.exam.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.baidu.exam.common.Constant;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.UserService;

/**
 * Created by langshiquan on 17/9/13.
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    public final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    // for fe to getById loginUser id
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser(HttpSession session) {
        User user = (User) session.getAttribute(Constant.USER_SESSION_ATTRIBUTE);
        user = userService.getUsers(user.getId()).get(0);
        return JSON.toJSONString(user);
    }
}
