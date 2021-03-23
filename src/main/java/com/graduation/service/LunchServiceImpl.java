package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.repository.LunchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchServiceImpl implements LunchService {

    private final LunchRepository repository;

    public LunchServiceImpl(LunchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Lunch> getAll() {
        return (List<Lunch>) repository.findAll();
    }

    @Override
    public List<Lunch> getByRestaurantName(String name) {
        return repository.getByRestaurantName(name);
    }

    @Override
    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDatesIncluding(startDate, endDate);
    }

    @Override
    public List<Lunch> getByRestaurantNameBetweenDates(String restaurantName, LocalDate startDate, LocalDate endDate) {
        return repository.getByRestaurantNameBetweenDates(restaurantName, startDate, endDate);
    }
}
