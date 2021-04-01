package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lunches")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Lunch extends AbstractBaseEntity {

    @Column(name = "date_registered")
    private LocalDate dateRegistered;

    @Column(name = "lunch_name")
    private String lunchName;

    @Column(name = "price")
    private int price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public Lunch(Integer id, LocalDate dateRegistered, String lunchName, int price, Restaurant restaurant) {
        super(id);
        this.dateRegistered = dateRegistered;
        this.lunchName = lunchName;
        this.price = price;
        this.restaurant = restaurant;
    }
}
