package com.graduation.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int user_id;
    private String name;
    private String surname;
    private String email;
    private String password;

}
