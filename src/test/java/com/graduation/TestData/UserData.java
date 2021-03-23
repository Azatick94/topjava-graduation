package com.graduation.TestData;

import com.graduation.model.User;

import java.util.List;

public class UserData {

    public static User user1 = new User(100002, "Azat", "Burkhanov", "azburhanov@mail.ru", "password");
    public static User user2 = new User(100003, "Vadim", "Demchenko", "demo@gmail.com", "qwerty");
    public static User user3 = new User(100004, "Petr", "Petrov", "petrov_petr@mail.ru", "qwerty123");
    public static User user4 = new User(100005, "Elena", "Barinova", "lena_barinova@gmail.com", "123qwerty");

    public static List<User> users = List.of(user1, user2, user3, user4);
}
