package com.graduation.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "vote_id")
    private Integer voteId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "vote_date_time")
    private LocalDateTime voteDateTime;

}
