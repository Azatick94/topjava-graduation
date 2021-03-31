package com.graduation.service;

import com.graduation.model.User;
import com.graduation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return null;
//        return (List<User>) repository.findAll();
    }

    @Override
    public User getById(int id) {
        return null;
//        return repository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return null;
//        return repository.save(user);
    }

    @Override
    public void update(User user, int id) {
//        repository.save(user);
    }

    @Override
    public void delete(int id) {
//        repository.delete(id);
    }

    public List<User> getByName(String name) {
//        return repository.findByName(name);
        return null;
    }
}
