package com.graduation.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class VoteHistory {

    private Integer restaurant_id;

    private LocalDate date;

    public VoteHistory(Integer restaurant_id, LocalDate date) {
        this.restaurant_id = restaurant_id;
        this.date = date;
    }
}