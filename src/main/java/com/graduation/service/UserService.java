package com.graduation.service;

import com.graduation.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> getByName(String name);
}
