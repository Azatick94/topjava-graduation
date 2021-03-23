package com.graduation.service;

import com.graduation.model.User;
import com.graduation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public List<User> getByName(String name) {
        return repository.findByName(name);
    }
}
