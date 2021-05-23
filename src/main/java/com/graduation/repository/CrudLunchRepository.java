package com.graduation.repository;

import com.graduation.model.Lunch;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CrudLunchRepository extends CrudRepository<Lunch, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l LEFT JOIN FETCH l.restaurant")
    List<Lunch> findAll();

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l LEFT JOIN FETCH l.restaurant WHERE l.id=:id")
    Optional<Lunch> findById(@Param("id") Integer id);

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l LEFT JOIN FETCH l.restaurant WHERE l.restaurant.id=:restaurantId")
    List<Lunch> getByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l LEFT JOIN FETCH l.restaurant WHERE l.dateRegistered >= :startDate AND l.dateRegistered <= :endDate")
    List<Lunch> getBetweenDatesIncluding(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lunch l LEFT JOIN FETCH l.restaurant WHERE l.dateRegistered = :date")
    List<Lunch> getByDate(@Param("date") LocalDate date);

    @Modifying
    @Query("DELETE FROM Lunch l WHERE l.id=:id")
    Integer delete(@Param("id") Integer id);
}
