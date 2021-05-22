package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.to.RestaurantTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

@Service
public class RestaurantService {

    private final CrudRestaurantRepository crudRepo;

    public RestaurantService(CrudRestaurantRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    @Transactional(readOnly = true)
    public List<Restaurant> getAll() {
        return crudRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Restaurant getById(Integer id) {
        return findByIdThrowExceptionIfNotFound(crudRepo, id);
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
