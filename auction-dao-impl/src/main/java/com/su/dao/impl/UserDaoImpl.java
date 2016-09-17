package com.su.dao.impl;

import com.su.dao.api.UserDao;
import com.su.domain.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    private void generateUsers(){
        users.add(new User("tim", "Tim", "Tompson"));
        users.add(new User("whity", "Jack", "White"));
        users.add(new User("blacky", "Sem", "Black"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User entity) {
        users.add(entity);

    }

    @Override
    public void remote(User entity) {
        users.remove(entity);

    }
}
