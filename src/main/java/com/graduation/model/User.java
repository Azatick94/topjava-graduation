package com.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.persistence.FetchType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    @NotBlank
    @Column(name = "name")
    private String name;

    @Size(max = 100)
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique")})
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(Integer id, String name, String surname, String email, String password) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
