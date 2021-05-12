package com.graduation.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LunchTo {

    private LocalDate dateRegistered;

    @Size(max = 200)
    @NotBlank
    private String lunchName;

    @Range(min = 0, max = 999999)
    @NotNull
    private Integer price;

    @Min(0)
    @NotNull
    private Integer restaurantId;
}
