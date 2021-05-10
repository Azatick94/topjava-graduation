package com.graduation.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteTo {

    private Integer restaurantId;

    private LocalDateTime voteDateTime;
}
