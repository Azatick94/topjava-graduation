package com.graduation.repository;

import com.graduation.model.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudRestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findAll();

    Restaurant getByRestaurantName(String restaurantName);

    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);
}
