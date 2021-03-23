package com.graduation.service;

import com.graduation.TestData.UserData;
import com.graduation.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserServiceImplTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getAllTest() {
        List<User> calculatedUsers = service.getAll();
        List<User> expectedUsers = UserData.users;
        assertThat(calculatedUsers).isEqualTo(expectedUsers);
    }

    @Test
    public void getByNameTest() {
        List<User> calculatedUsers = service.getByName("Azat");
        List<User> expectedUsers = List.of(UserData.user1);
        assertThat(calculatedUsers).isEqualTo(expectedUsers);
    }
}