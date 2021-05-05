package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "votes_history")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class VoteHistory extends AbstractBaseEntity {

    @Column(name = "restaurant_id")
    private Integer restaurant_id;

    @Column(name = "date")
    private LocalDate date;

    public VoteHistory(Integer restaurant_id, LocalDate date) {
        this.restaurant_id = restaurant_id;
        this.date = date;
    }

    public VoteHistory(Integer id, Integer restaurant_id, LocalDate date) {
        super(id);
        this.restaurant_id = restaurant_id;
        this.date = date;
    }
}
