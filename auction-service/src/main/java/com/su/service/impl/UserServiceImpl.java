package com.su.service.impl;

import com.su.dao.api.UserDao;
import com.su.domain.User;
import com.su.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User createUser(String login, String firstName, String lastName) {
        User user = new User(login, firstName, lastName);
        userDao.add(user);
        return user;
    }
}
