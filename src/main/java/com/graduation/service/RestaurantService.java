package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements BaseService<Restaurant> {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public Restaurant getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return repository.create(restaurant);
    }

    @Override
    public void update(Restaurant restaurant, int id) {
        repository.update(restaurant, id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    public Restaurant getByName(String restaurantName) {
        return repository.getByRestaurantName(restaurantName);
    }
}
