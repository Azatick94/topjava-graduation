package com.graduation.repository;

import com.graduation.model.Lunch;
import com.graduation.repository.crud.CrudLunchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LunchRepository implements BaseRepository<Lunch> {

    private final CrudLunchRepository crudRepo;

    public LunchRepository(CrudLunchRepository crudRepo) {
        this.crudRepo = crudRepo;
    }

    @Override
    public List<Lunch> getAll() {
        return (List<Lunch>) crudRepo.findAll();
    }

    @Override
    public Lunch getById(int id) {
        return crudRepo.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        crudRepo.delete(id);
    }

    @Transactional
    @Override
    public Lunch create(Lunch lunch) {
        return crudRepo.save(lunch);
    }

    @Transactional
    @Override
    public void update(Lunch lunch, int id) {
        lunch.setId(id);
        crudRepo.save(lunch);
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
