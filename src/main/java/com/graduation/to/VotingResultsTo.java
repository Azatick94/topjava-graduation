package com.graduation.to;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
