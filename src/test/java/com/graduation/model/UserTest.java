package com.graduation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void userInitializationTest() {
        User user = new User();

        User user2 = new User(100002, "Azat", "Burkhanov", "azburhanov@mail.ru", "password");
    }

}