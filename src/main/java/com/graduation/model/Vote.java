package com.graduation.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    private int vote_id;

    private int user_id;

    private LocalDateTime vote_date;

    private String restaurant_name;

}
