package com.graduation.service;

import com.graduation.model.Lunch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LunchServiceImplTest {

    @Autowired
    LunchService service;

    @Test
    void getAllTest() {
        List<Lunch> lunches = service.getAll();
        assertEquals(lunches.size(), 20);
    }

    @Test
    void getByRestaurantName() {
        List<Lunch> lunchesByName = service.getByRestaurantName("AnderSon");
        assertEquals(lunchesByName.size(), 5);
    }

    @Test
    void getBetweenDatesIncluding() {
        List<Lunch> lunchesBetweenDates = service.getBetweenDatesIncluding(LocalDate.of(2021, 1, 2),
                LocalDate.of(2021, 1, 2));
        assertEquals(lunchesBetweenDates.size(), 2);
    }

    @Test
    void getByRestaurantNameBetweenDates() {
        List<Lunch> lunchesByRestaurantNameBetweenDates = service.getByRestaurantNameBetweenDates("Khachapuri",
                LocalDate.of(2021, 1, 2), LocalDate.of(2021, 1, 2));
        assertEquals(lunchesByRestaurantNameBetweenDates.size(), 1);
    }
}