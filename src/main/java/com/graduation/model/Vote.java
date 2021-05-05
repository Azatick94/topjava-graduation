package com.graduation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Vote extends AbstractBaseEntity {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "vote_date_time")
    private LocalDateTime voteDateTime;

    @Column(name = "vote_date")
    private LocalDate voteDate;

    public Vote(Integer id, Integer userId, Integer restaurantId, LocalDateTime voteDateTime) {
        super(id);
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.voteDateTime = voteDateTime;
    }
}
