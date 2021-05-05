package com.graduation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Setter
@Getter
@ToString(callSuper = true, exclude = {"password"})
@NoArgsConstructor
public class User extends AbstractBaseEntity {

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Size(max = 100)
    @Column(name = "surname")
    private String surname;

    @Email
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @Size(max = 100)
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
