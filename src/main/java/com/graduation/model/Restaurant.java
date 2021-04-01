package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "restaurant_name")
    String restaurantName;

    public Restaurant(Integer id, String restaurantName) {
        super(id);
        this.restaurantName = restaurantName;
    }
}
