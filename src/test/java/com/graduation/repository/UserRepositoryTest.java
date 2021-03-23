package com.graduation.repository;

import com.graduation.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getAllTest() {
        List<User> users = (List<User>) userRepository.findAll();
        assertNotEquals(0, users.size());
    }
}