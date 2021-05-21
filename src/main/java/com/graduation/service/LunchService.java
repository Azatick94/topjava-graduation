package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.model.Restaurant;
import com.graduation.repository.CrudLunchRepository;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.to.LunchTo;
import com.graduation.util.exception.IdNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchService {

    private final CrudLunchRepository crudRepo;

    private final CrudRestaurantRepository crudRestaurantRepo;

    public LunchService(CrudLunchRepository crudLunchRepo, CrudRestaurantRepository crudRestaurantRepo) {
        this.crudRepo = crudLunchRepo;
        this.crudRestaurantRepo = crudRestaurantRepo;
    }

    @Transactional(readOnly = true)
    public List<Lunch> getAll() {
        return (List<Lunch>) crudRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Lunch getById(Integer id) {
        return crudRepo.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Lunch> getByRestaurantId(Integer restaurantId) {
        return crudRepo.getByRestaurantId(restaurantId);
    }

    @Transactional(readOnly = true)
    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return crudRepo.getBetweenDatesIncluding(startDate, endDate);
    }

    @Transactional
    public Lunch save(LunchTo lunchTo) {
        Integer restaurantId = lunchTo.getRestaurantId();
        Restaurant restaurant = crudRestaurantRepo.findById(restaurantId).orElseThrow(() -> new IdNotFoundException(restaurantId));

        Lunch lunch = new Lunch(null, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), restaurant);

        return crudRepo.save(lunch);
    }

    @Transactional
    public void update(LunchTo lunchTo, Integer id) {
        Integer restaurantId = lunchTo.getRestaurantId();
        Restaurant restaurant = crudRestaurantRepo.findById(restaurantId).orElseThrow(() -> new IdNotFoundException(restaurantId));

        Lunch lunch = new Lunch(id, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), restaurant);
        crudRepo.save(lunch);
    }

    @Transactional
    public void delete(Integer id) {
        crudRepo.delete(id);
    }
}
