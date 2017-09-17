package com.baidu.exam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.exam.module.User;

/**
 * Created by langshiquan on 17/9/13.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findByUsernameAndPassword(String username, String password);
}
