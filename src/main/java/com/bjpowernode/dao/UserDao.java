package com.bjpowernode.dao;

import com.bjpowernode.domain.User;

public interface UserDao {
    User select(Integer id);

    void update(User use);

    User select1(String key);
}
