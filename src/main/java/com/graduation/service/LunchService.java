package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.repository.LunchRepository;
import com.graduation.to.LunchTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchService {

    private final LunchRepository repository;

    public LunchService(LunchRepository repository) {
        this.repository = repository;
    }

    public List<Lunch> getAll() {
        return repository.getAll();
    }

    public Lunch getById(int id) {
        return repository.getById(id);
    }

    public List<Lunch> getByRestaurantName(String name) {
        return repository.getByRestaurantName(name);
    }

    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return repository.getBetweenDatesIncluding(startDate, endDate);
    }

    public Lunch save(LunchTo lunchTo) {
        Lunch lunch = new Lunch(null, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), lunchTo.getRestaurant());
        return repository.create(lunch);
    }

    public void update(LunchTo lunchTo, int id) {
        Lunch lunch = new Lunch(id, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), lunchTo.getRestaurant());
        repository.update(lunch, id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}
