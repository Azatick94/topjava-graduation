package com.graduation.to;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class VotingResultsTo {

    private Integer restaurantId;

    private String restaurantName;

    private LocalDate voteDate;

    private Integer counts;
}
