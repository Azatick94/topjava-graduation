package com.graduation.TestData;

import com.graduation.model.Restaurant;

import java.util.List;

public class RestaurantData {

    public static Restaurant restaurant1 = new Restaurant(100006, "AnderSon");
    public static Restaurant restaurant2 = new Restaurant(100007, "Russian Pub");
    public static Restaurant restaurant3 = new Restaurant(100008, "Italoniya");
    public static Restaurant restaurant4 = new Restaurant(100009, "Piccochino");
    public static Restaurant restaurant5 = new Restaurant(100010, "Bardak");
    public static Restaurant restaurant6 = new Restaurant(100011, "Khachapuri");

    public static List<Restaurant> allRestaurants = List.of(restaurant1, restaurant2, restaurant3, restaurant4, restaurant5, restaurant6);

    public static Restaurant getNewRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("New_Restaurant");
        return restaurant;
    }
}
