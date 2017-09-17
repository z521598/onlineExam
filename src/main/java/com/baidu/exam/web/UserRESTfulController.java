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
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.UserService;

/**
 * Created by langshiquan on 17/9/13.
 */

@Controller
@RequestMapping("/user")
public class UserRESTfulController extends BaseController {

    public final static Logger LOG = LoggerFactory.getLogger(UserRESTfulController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String add(User user) {
        if (userService.checkUserExist(user)) {
            return "注册失败，用户名已存在";
        }
        LOG.info("register user : {}", user);
        try {
            userService.save(user);
            return "注册成功";
        } catch (Exception e) {
            return "注册失败,未知错误:" + e.getMessage();
        }
    }

    // 如果是0，则查所有
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable Long id) {
        List<User> userList = userService.getUsers(id);
        return JSON.toJSONString(userList);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        userService.deleteUser(id);
        return JSON.toJSONString(resultBean);
    }
}
