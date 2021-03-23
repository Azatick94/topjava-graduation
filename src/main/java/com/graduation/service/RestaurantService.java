package com.graduation.service;

import com.graduation.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();

    Restaurant getByName(String restaurantName);

    Restaurant getById(int id);
}
