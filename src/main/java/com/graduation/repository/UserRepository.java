package com.graduation.repository;

import com.graduation.model.User;
import com.graduation.repository.crud.CrudUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository implements BaseRepository<User> {

    private final CrudUserRepository crudRepo;

    public UserRepository(CrudUserRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) crudRepo.findAll();
    }

    @Override
    public User getById(int id) {
        return crudRepo.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(int id) {
        crudRepo.delete(id);
    }

    @Transactional
    @Override
    public User create(User user) {
        return crudRepo.save(user);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        crudRepo.save(user);
    }

    public List<User> getByName(String name) {
        return crudRepo.getByName(name);
    }
}
