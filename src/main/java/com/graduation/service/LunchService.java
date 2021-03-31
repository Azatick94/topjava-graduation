package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.repository.LunchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchService implements BaseService<Lunch> {

    private final LunchRepository repository;

    public LunchService(LunchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Lunch> getAll() {
        return repository.getAll();
    }

    @Override
    public Lunch getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Lunch save(Lunch lunch) {
        return repository.create(lunch);
    }

    @Override
    public void update(Lunch lunch, int id) {
        repository.update(lunch, id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    public List<Lunch> getByRestaurantName(String name) {
        return repository.getByRestaurantName(name);
    }

    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDatesIncluding(startDate, endDate);
    }

    public List<Lunch> getByRestaurantNameBetweenDates(String restaurantName, LocalDate startDate, LocalDate endDate) {
        return repository.getByRestaurantNameBetweenDates(restaurantName, startDate, endDate);
    }
}
