package com.graduation.repository;

import com.graduation.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    Restaurant findByRestaurantName(String restaurantName);
}
