package com.graduation.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lunches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lunch {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "lunch_id")
    private Integer lunchId;

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

    public boolean isNew() {
        return this.lunchId == null;
    }
}
