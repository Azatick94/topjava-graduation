package com.graduation.service;

import com.graduation.model.Lunch;
import com.graduation.model.Restaurant;
import com.graduation.repository.CrudLunchRepository;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.to.LunchTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

@Service
public class LunchService {

    private final CrudLunchRepository crudRepo;

    private final CrudRestaurantRepository crudRestaurantRepo;

    public LunchService(CrudLunchRepository crudLunchRepo, CrudRestaurantRepository crudRestaurantRepo) {
        this.crudRepo = crudLunchRepo;
        this.crudRestaurantRepo = crudRestaurantRepo;
    }

    public List<Lunch> getAll() {
        return crudRepo.findAll();
    }

    public Lunch getById(Integer id) {
        return findByIdThrowExceptionIfNotFound(crudRepo, id);
    }

    public List<Lunch> getByRestaurantId(Integer restaurantId) {
        return crudRepo.getByRestaurantId(restaurantId);
    }

    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return crudRepo.getBetweenDatesIncluding(startDate, endDate);
    }

    public List<Lunch> getByDate(LocalDate date) {
        return crudRepo.getByDate(date);
    }

    @Transactional
    public Lunch save(LunchTo lunchTo) {
        Lunch lunch = new Lunch(null, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), saveOrUpdateUtil(lunchTo));
        return crudRepo.save(lunch);
    }

    @Transactional
    public void update(LunchTo lunchTo, Integer id) {
        Lunch lunch = new Lunch(id, lunchTo.getDateRegistered(), lunchTo.getLunchName(),
                lunchTo.getPrice(), saveOrUpdateUtil(lunchTo));
        crudRepo.save(lunch);
    }

    @Transactional
    public void delete(Integer id) {
        crudRepo.delete(id);
    }

    private Restaurant saveOrUpdateUtil(LunchTo lunchTo) {
        Integer restaurantId = lunchTo.getRestaurantId();
        return findByIdThrowExceptionIfNotFound(crudRestaurantRepo, restaurantId);
    }
}
