package com.graduation.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteTo {

    @Min(0)
    @NotNull
    private Integer restaurantId;

    private LocalDateTime voteDateTime;
}
