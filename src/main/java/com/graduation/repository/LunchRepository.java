package com.graduation.repository;

import com.graduation.model.Lunch;
import com.graduation.repository.crud.CrudLunchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LunchRepository {

    private final CrudLunchRepository crudRepo;

    public LunchRepository(CrudLunchRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    @Transactional
    public Lunch save(Lunch lunch) {
        if (lunch == null) {
            return null;
        }
        return crudRepo.save(lunch);
    }

    @Transactional
    public boolean delete(int lunchId) {
        return crudRepo.delete(lunchId) != 0;
    }

    public Lunch getByLunchId(int lunchId) {
        return crudRepo.getByLunchId(lunchId);
    }

    public List<Lunch> getAll() {
        return (List<Lunch>) crudRepo.findAll();
    }

    public List<Lunch> getByRestaurantName(String restaurantName) {
        return crudRepo.getByRestaurantName(restaurantName);
    }

    public List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate) {
        return crudRepo.getBetweenDatesIncluding(startDate, endDate);
    }

    public List<Lunch> getByRestaurantNameBetweenDates(String restaurantName, LocalDate startDate, LocalDate endDate) {
        return crudRepo.getByRestaurantNameBetweenDates(restaurantName, startDate, endDate);
    }
}
