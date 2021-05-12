package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "lunches")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Lunch extends AbstractBaseEntity {

    @Column(name = "date_registered")
    private LocalDate dateRegistered;

    @Column(name = "lunch_name")
    @Size(max = 200)
    @NotBlank
    private String lunchName;

    @Range(min = 0, max = 999999)
    @Column(name = "price")
    private Integer price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Lunch(Integer id, LocalDate dateRegistered, String lunchName, Integer price, Restaurant restaurant) {
        super(id);
        this.dateRegistered = dateRegistered;
        this.lunchName = lunchName;
        this.price = price;
        this.restaurant = restaurant;
    }
}
