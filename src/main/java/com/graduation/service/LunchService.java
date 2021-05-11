package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.repository.crud.CrudLunchRepository;
import com.graduation.to.LunchTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LunchService {

    private final CrudLunchRepository crudRepo;

    public LunchService(CrudLunchRepository crudLunchRepo) {
        this.crudRepo = crudLunchRepo;
    }

    public List<Lunch> getAll() {
        return (List<Lunch>) crudRepo.findAll();
    }

    public Lunch getById(int id) {
        return crudRepo.getById(id);
    }

    public List<Lunch> getByRestaurantName(String name) {
        return crudRepo.getByRestaurantName(name);
    }

    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return crudRepo.getBetweenDatesIncluding(startDate, endDate);
    }

    @Transactional
    public Lunch save(LunchTo lunchTo) {
        Lunch lunch = new Lunch(null, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), lunchTo.getRestaurant());
        return crudRepo.save(lunch);
    }

    @Transactional
    public void update(LunchTo lunchTo, int id) {
        Lunch lunch = new Lunch(id, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), lunchTo.getRestaurant());
        crudRepo.save(lunch);
    }

    @Transactional
    public void delete(int id) {
        crudRepo.delete(id);
    }
}
