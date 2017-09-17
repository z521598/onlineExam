package com.baidu.exam.service.impl;

import java.util.List;

import com.baidu.exam.module.User;

/**
 * Created by langshiquan on 17/9/13.
 */
public interface UserService {
    Long save(User user);

    Boolean checkUserExist(User user);

    Boolean login(User user);

    List<User> getUsers(Long id);

    Boolean deleteUser(Long id);
}
