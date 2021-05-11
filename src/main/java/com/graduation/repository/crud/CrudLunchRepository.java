package com.graduation.repository.crud;

import com.graduation.model.Lunch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CrudLunchRepository extends CrudRepository<Lunch, Integer> {

    @Query("SELECT l FROM Lunch l WHERE l.restaurant.restaurantName=:restaurantName")
    List<Lunch> getByRestaurantName(@Param("restaurantName") String restaurantName);

    @Query("SELECT l FROM Lunch l WHERE l.dateRegistered >= :startDate AND l.dateRegistered <= :endDate")
    List<Lunch> getBetweenDatesIncluding(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    Lunch getById(int lunchId);

    @Modifying
    @Query("DELETE FROM Lunch l WHERE l.id=:id")
    int delete(@Param("id") int id);
}
