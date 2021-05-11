package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.crud.CrudRestaurantRepository;
import com.graduation.to.RestaurantSaveTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private final CrudRestaurantRepository crudRepo;

    public RestaurantService(CrudRestaurantRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    public List<Restaurant> getAll() {
        return (List<Restaurant>) crudRepo.findAll();
    }

    public Restaurant getById(int id) {
        return crudRepo.findById(id).orElse(null);
    }

    public Restaurant getByName(String restaurantName) {
        return crudRepo.getByRestaurantName(restaurantName);
    }

    @Transactional
    public Restaurant save(RestaurantSaveTo restaurantSaveTo) {
        Restaurant restaurant = new Restaurant(null, restaurantSaveTo.getRestaurantName());
        return crudRepo.save(restaurant);
    }

    @Transactional
    public void update(RestaurantSaveTo restaurantSaveTo, int id) {
        Restaurant restaurant = new Restaurant(id, restaurantSaveTo.getRestaurantName());
        crudRepo.save(restaurant);
    }

    @Transactional
    public void delete(int id) {
        crudRepo.delete(id);
    }
}
