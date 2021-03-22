package com.graduation.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lunch {

    private int lunch_id;
    private LocalDateTime date_registered;
    private String restaurant_name;
    private String lunch_name;
    private int price;

}
