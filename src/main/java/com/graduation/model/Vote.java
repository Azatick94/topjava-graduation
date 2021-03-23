package com.graduation.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    @Column(name = "vote_id")
    private int voteId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "vote_date")
    private LocalDateTime voteDate;

}
