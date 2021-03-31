package com.graduation.web;

import com.graduation.model.Restaurant;
import com.graduation.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("Getting All Restaurants");
        return restaurantService.getAll();
    }

    @GetMapping("{id}")
    public Restaurant getById(@PathVariable int id) {
        log.info("Getting Restaurant By Id: " + id);
        return restaurantService.getById(id);
    }

    @PostMapping
    public Restaurant save(@RequestBody Restaurant restaurant) {
        log.info("Saving restaurant");
        return restaurantService.save(restaurant);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("Updating Restaurant");
        restaurantService.update(restaurant, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        log.info("Deleting Restaurant");
        restaurantService.delete(id);
    }
}
