package com.graduation.to;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@ToString()
public class VoteQueryByDateTo {

    private Integer restaurantId;

    private String restaurantName;

    private LocalDate voteDate;

    private Integer counts;
}
