package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import com.bjpowernode.util.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSession().getMapper(UserDao.class);
    @Override
    public User select(Integer id) {
        User u = userDao.select(1);
        return  u;
    }

    @Override
    public void update(User use) {
        userDao.update(use);
    }

    @Override
    public User select1(String key) {
        User u = userDao.select1(key);
        return u;
    }
}
