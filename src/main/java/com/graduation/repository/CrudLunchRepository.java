package com.graduation.repository;

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

    List<Lunch> findAll();

    @Query("SELECT l FROM Lunch l WHERE l.restaurant.id=:restaurantId")
    List<Lunch> getByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Query("SELECT l FROM Lunch l WHERE l.dateRegistered >= :startDate AND l.dateRegistered <= :endDate")
    List<Lunch> getBetweenDatesIncluding(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT l FROM Lunch l WHERE l.dateRegistered = :date")
    List<Lunch> getByDate(@Param("date") LocalDate date);

    @Modifying
    @Query("DELETE FROM Lunch l WHERE l.id=:id")
    Integer delete(@Param("id") Integer id);
}
