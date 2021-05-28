package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "lunches", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "lunch_name"}, name = "lunches_unique_restaurant_id_lunch_name")})
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

    // https://thorben-janssen.com/lazyinitializationexception/#:~:text=Hibernate%20throws%20the%20LazyInitializationException%20when,client%20application%20or%20web%20layer.
    // TO Replace EAGER
    @OneToOne(fetch = FetchType.LAZY)
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
