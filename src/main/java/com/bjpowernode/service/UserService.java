package com.bjpowernode.service;

import com.bjpowernode.domain.User;

public interface UserService {
    public User select(Integer id);

    void update(User use);

    User select1(String key);
}
