package com.baidu.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baidu.exam.module.Notice;

/**
 * Created by langshiquan on 17/9/13.
 */
@Repository
public interface NoticeDao extends JpaRepository<Notice,Long> {
}
