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
        return repository.getAll();
    }

    @Override
    public User getById(int id) {
        return repository.getById(id);
    }

    public List<User> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public User save(User user) {
        return repository.create(user);
    }

    @Override
    public void update(User user, int id) {
        repository.update(user, id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }


}
