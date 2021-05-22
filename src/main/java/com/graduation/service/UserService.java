package com.graduation.service;

import com.graduation.model.User;
import com.graduation.repository.CrudUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

@Service
public class UserService {

    private final CrudUserRepository userRepo;

    public UserService(CrudUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return findByIdThrowExceptionIfNotFound(userRepo, id);
    }

    @Transactional(readOnly = true)
    public List<User> getByName(String name) {
        return userRepo.getByName(name);
    }

    @Transactional
    public User save(User user) {
        user.setId(null);
        return userRepo.save(user);
    }

    @Transactional
    public void delete(Integer id) {
        userRepo.delete(id);
    }
}
