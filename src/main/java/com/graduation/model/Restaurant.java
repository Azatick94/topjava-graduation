package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "restaurant_name"}, name = "restaurants_unique_id_restaurant_name")})
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Restaurant extends AbstractBaseEntity {

    @Size(max = 100)
    @NotBlank
    @Column(name = "restaurant_name")
    private String restaurantName;

    public Restaurant(Integer id, String restaurantName) {
        super(id);
        this.restaurantName = restaurantName;
    }
}
