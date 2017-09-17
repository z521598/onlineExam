package com.baidu.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.exam.dao.UserDao;
import com.baidu.exam.module.User;
import com.baidu.exam.service.impl.UserService;

/**
 * Created by langshiquan on 17/9/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Long save(User user) {
        User resUser = userDao.save(user);
        return resUser.getId();
    }

    @Override
    public Boolean checkUserExist(User user) {
        List<User> userList = userDao.findByUsername(user.getUsername());
        if (userList != null && userList.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        List<User> userList = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUsers(Long id) {
        List<User> list = new ArrayList<>();
        if (id == 0l) {
            list = userDao.findAll();
        } else {
            list.add(userDao.findOne(id));
        }
        return list;
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            userDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
