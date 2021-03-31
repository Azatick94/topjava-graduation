package com.graduation.service;

import com.graduation.model.Lunch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LunchServiceImplTest extends AbstractServiceTest {
//
//    @Autowired
//    BaseService lunchService;
//
//    @Autowired
//    RestaurantService restaurantService;
//
//    @Test
//    void saveNewLunchTest() {
//        Lunch newLunch = new Lunch();
//        newLunch.setDateRegistered(LocalDate.of(2021, 1, 1));
//        newLunch.setLunchName("Test Lunch");
//        newLunch.setPrice(100);
//        newLunch.setRestaurant(restaurantService.getByName("AnderSon"));
//
//        Lunch expectedLunch = new Lunch(100036, LocalDate.of(2021, 1, 1), "Test Lunch", 100, restaurantService.getByName("AnderSon"));
//        Lunch savedLunch = (Lunch) lunchService.save(newLunch);
//
//        assertThat(savedLunch).isEqualTo(expectedLunch);
//    }
//
//    @Test
//    void updateLunchTest() {
//        Lunch newLunch = (Lunch) lunchService.getById(100012);
//        newLunch.setLunchName("Updated Lunch name");
//        newLunch.setPrice(777);
//
//        Lunch expectedLunch = new Lunch(100012, LocalDate.of(2021, 1, 1), "Updated Lunch name", 777, restaurantService.getByName("AnderSon"));
//        Lunch updatedLunch = (Lunch) lunchService.save(newLunch);
//
//        assertThat(updatedLunch).isEqualTo(expectedLunch);
//    }
//
//
//    @Test
//    void deleteTest() {
//        lunchService.delete(100030);
//        assertNull(lunchService.getById(100030));
//    }
//
//    @Test
//    void getAllTest() {
//        List<Lunch> lunches = lunchService.getAll();
//        assertEquals(lunches.size(), 20);
//    }
//
//    @Test
//    void getByRestaurantName() {
//        List<Lunch> lunchesByName = lunchService.getByRestaurantName("AnderSon");
//        assertEquals(lunchesByName.size(), 5);
//    }
//
//    @Test
//    void getBetweenDatesIncluding() {
//        List<Lunch> lunchesBetweenDates = lunchService.getBetweenDatesIncluding(LocalDate.of(2021, 1, 2),
//                LocalDate.of(2021, 1, 2));
//        assertEquals(lunchesBetweenDates.size(), 2);
//    }
//
//    @Test
//    void getByRestaurantNameBetweenDates() {
//        List<Lunch> lunchesByRestaurantNameBetweenDates = lunchService.getByRestaurantNameBetweenDates("Khachapuri",
//                LocalDate.of(2021, 1, 2), LocalDate.of(2021, 1, 2));
//        assertEquals(lunchesByRestaurantNameBetweenDates.size(), 1);
//    }
}