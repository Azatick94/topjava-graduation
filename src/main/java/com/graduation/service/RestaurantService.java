package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.crud.CrudRestaurantRepository;
import com.graduation.to.RestaurantTo;
import com.graduation.util.exception.IdNotFoundException;
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

    public Restaurant getById(Integer id) {
        return crudRepo.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }

    public Restaurant getByName(String restaurantName) {
        return crudRepo.getByRestaurantName(restaurantName);
    }

    @Transactional
    public Restaurant save(RestaurantTo restaurantTo) {
        Restaurant restaurant = new Restaurant(null, restaurantTo.getRestaurantName());
        return crudRepo.save(restaurant);
    }

    @Transactional
    public void update(RestaurantTo restaurantTo, Integer id) {
        Restaurant restaurant = new Restaurant(id, restaurantTo.getRestaurantName());
        crudRepo.save(restaurant);
    }

    @Transactional
    public void delete(Integer id) {
        crudRepo.delete(id);
    }
}
