package com.graduation.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTo {

    @Size(max = 100)
    @NotBlank
    private String restaurantName;
}
