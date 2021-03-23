package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> getAll() {
        return (List<Restaurant>) repository.findAll();
    }

    @Override
    public Restaurant getByName(String restaurantName) {
        return repository.findByRestaurantName(restaurantName);
    }

    @Override
    public Restaurant getById(int id) {
        return repository.findById(id).orElse(null);
    }
}
