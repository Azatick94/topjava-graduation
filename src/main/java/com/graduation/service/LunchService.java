package com.graduation.service;

import com.graduation.model.Lunch;

import java.time.LocalDate;
import java.util.List;

public interface LunchService {

    List<Lunch> getAll();

    List<Lunch> getByRestaurantName(String name);

    List<Lunch> getBetweenDatesIncluding(LocalDate startDate, LocalDate endDate);

    List<Lunch> getByRestaurantNameBetweenDates(String name, LocalDate startDate, LocalDate endDate);

}
