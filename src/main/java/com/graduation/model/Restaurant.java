package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Restaurant extends AbstractBaseEntity {

    @Size(max = 100)
    @NotBlank
    @Column(name = "restaurant_name")
    String restaurantName;

    public Restaurant(Integer id, String restaurantName) {
        super(id);
        this.restaurantName = restaurantName;
    }
}
