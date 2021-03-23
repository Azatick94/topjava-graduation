package com.graduation.service;

import com.graduation.TestData.RestaurantData;
import com.graduation.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestaurantServiceImplTest {

    @Autowired
    private RestaurantService service;

    @Test
    void getAllTest() {
        List<Restaurant> calculatedRestaurants = service.getAll();
        List<Restaurant> expectedRestaurants = RestaurantData.allRestaurants;
        assertThat(calculatedRestaurants).isEqualTo(expectedRestaurants);
    }

    @Test
    void getByNameTest() {
        Restaurant restaurant = service.getByName("Italoniya");
        Restaurant expectedRestaurant = RestaurantData.restaurant3;
        assertThat(restaurant).isEqualTo(expectedRestaurant);
    }

    @Test
    void getByIdTest() {
        Restaurant restaurant = service.getById(100008);
        Restaurant expectedRestaurant = RestaurantData.restaurant3;
        assertThat(restaurant).isEqualTo(expectedRestaurant);
    }
}