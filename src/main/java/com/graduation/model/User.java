package com.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@ToString(callSuper = true, exclude = {"password"})
@NoArgsConstructor
public class User extends AbstractBaseEntity implements Serializable {

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
    @JsonIgnore
    @Column(name = "password")
    private String password;

    public User(Integer id, String name, String surname, String email, String password) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
