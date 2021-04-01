package com.graduation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(Integer id, String name, String surname, String email, String password) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
