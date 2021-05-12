package com.graduation.service;

import com.graduation.model.User;
import com.graduation.repository.crud.CrudUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final CrudUserRepository userRepo;

    public UserService(CrudUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getByName(String name) {
        return userRepo.getByName(name);
    }

    @Transactional
    public User save(User user) {
        user.setId(null);
        return userRepo.save(user);
    }

    @Transactional
    public void update(User user, Integer id) {
        user.setId(id);
        userRepo.save(user);
    }

    @Transactional
    public void delete(Integer id) {
        userRepo.delete(id);
    }
}
