package com.graduation.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VotingResultsTo {

    private Integer restaurantId;

    private String restaurantName;

    private LocalDate voteDate;

    private Long counts;
}
