package com.graduation.repository;

import com.graduation.model.Restaurant;
import com.graduation.repository.crud.CrudRestaurantRepository;
import com.graduation.to.RestaurantSaveTo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RestaurantRepository implements BaseRepository<Restaurant> {

    private final CrudRestaurantRepository crudRepo;

    public RestaurantRepository(CrudRestaurantRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    @Override
    public List<Restaurant> getAll() {
        return (List<Restaurant>) crudRepo.findAll();
    }

    @Override
    public Restaurant getById(int id) {
        return crudRepo.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(int id) {
        crudRepo.delete(id);
    }

    @Transactional
    @Override
    public Restaurant create(Restaurant restaurant) {
        return crudRepo.save(restaurant);
    }

    @Transactional
    public Restaurant create(RestaurantSaveTo restaurantSaveTo) {
        Restaurant restaurant = new Restaurant(null, restaurantSaveTo.getRestaurantName());
        return crudRepo.save(restaurant);
    }

    @Transactional
    public void update(Restaurant restaurant, int id) {
        restaurant.setId(id);
        crudRepo.save(restaurant);
    }

    @Transactional
    public void update(RestaurantSaveTo restaurantSaveTo, int id) {
        Restaurant restaurant = new Restaurant(id, restaurantSaveTo.getRestaurantName());
        crudRepo.save(restaurant);
    }

    public Restaurant getByRestaurantName(String restaurantName) {
        return crudRepo.getByRestaurantName(restaurantName);
    }
}
