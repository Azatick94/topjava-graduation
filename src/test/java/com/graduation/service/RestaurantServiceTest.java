package com.graduation.service;

import com.graduation.AbstractTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RestaurantServiceTest extends AbstractTest {
//
//    @Autowired
//    private RestaurantService service;
//
//    @Test
//    void getAllTest() {
//        List<Restaurant> calculated = service.getAll();
//        List<Restaurant> expected = RestaurantData.allRestaurants;
//        assertThat(calculated).isEqualTo(expected);
//    }
//
//    @Test
//    void getByNameTest() {
//        Restaurant calculated = service.getByName("Italoniya");
//        Restaurant expected = RestaurantData.restaurant3;
//        assertThat(calculated).isEqualTo(expected);
//    }
//
//    @Test
//    void getByIdTest() {
//        Restaurant calculated = service.getById(100008);
//        Restaurant expected = RestaurantData.restaurant3;
//        assertThat(calculated).isEqualTo(expected);
//    }
//
//    @Test
//    void saveTest() {
//        Restaurant newRestaurant = RestaurantData.getNewRestaurant();
//        Restaurant saved = service.save(newRestaurant);
//
//        Restaurant expected = new Restaurant(100036, "New_Restaurant");
//        assertThat(saved).isEqualTo(expected);
//    }
//
//    @Test
//    void updateTest() {
//
//        Restaurant restaurant = new Restaurant(100007, "Russian NewPub");
//        service.update(restaurant, 100007);
//        Restaurant updated = service.getById(100007);
//
//        assertThat(updated).isEqualTo(restaurant);
//    }
//
//    @Test
//    void deleteTest() {
//        service.delete(100006);
//        Restaurant result = service.getById(100006);
//        assertThat(result).isEqualTo(null);
//    }
}