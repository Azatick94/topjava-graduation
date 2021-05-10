package com.graduation.repository;

import com.graduation.model.Restaurant;
import com.graduation.repository.crud.CrudRestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RestaurantRepository {

    private final CrudRestaurantRepository crudRepo;

    public RestaurantRepository(CrudRestaurantRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    public List<Restaurant> getAll() {
        return (List<Restaurant>) crudRepo.findAll();
    }

    public Restaurant getById(int id) {
        return crudRepo.findById(id).orElse(null);
    }

    public Restaurant getByRestaurantName(String restaurantName) {
        return crudRepo.getByRestaurantName(restaurantName);
    }

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return crudRepo.save(restaurant);
    }

    @Transactional
    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        crudRepo.save(restaurant);
    }

    @Transactional
    public void delete(int id) {
        crudRepo.delete(id);
    }
}
