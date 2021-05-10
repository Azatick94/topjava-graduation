package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.RestaurantRepository;
import com.graduation.to.RestaurantSaveTo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public Restaurant getById(int id) {
        return repository.getById(id);
    }

    public Restaurant getByName(String restaurantName) {
        return repository.getByRestaurantName(restaurantName);
    }

    public Restaurant save(RestaurantSaveTo restaurantSaveTo) {
        Restaurant restaurant = new Restaurant(null, restaurantSaveTo.getRestaurantName());
        return repository.create(restaurant);
    }

    public void update(RestaurantSaveTo restaurantSaveTo, int id) {
        Restaurant restaurant = new Restaurant(id, restaurantSaveTo.getRestaurantName());
        repository.update(restaurant, id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
