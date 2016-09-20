package com.su.service;

import com.su.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User createUser(String login, String firstName, String lastName);

}
