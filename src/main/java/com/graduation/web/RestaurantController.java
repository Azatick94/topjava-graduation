package com.graduation.web;

import com.graduation.model.Restaurant;
import com.graduation.service.RestaurantService;
import com.graduation.to.RestaurantTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Restaurants", description = "Restaurants API")
@PreAuthorize("isAuthenticated()")
@Slf4j
@RequestMapping("/rest/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    @Operation(summary = "Get All Restaurants")
    public List<Restaurant> getAll() {
        log.info("Getting All Restaurants");
        return restaurantService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Restaurants By Id")
    public Restaurant getById(@PathVariable int id) {
        log.info("Getting Restaurant With Id = " + id);
        return restaurantService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Save New Restaurant")
    public Restaurant save(@Valid @RequestBody RestaurantTo restaurantTo) {
        log.info("Saving restaurant");
        return restaurantService.save(restaurantTo);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update Existing Restaurant By Id")
    public void update(@Valid @RequestBody RestaurantTo restaurantTo, @PathVariable int id) {
        log.info("Updating Restaurant With Id = " + id);
        restaurantService.update(restaurantTo, id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Restaurant By Id")
    public void delete(@PathVariable int id) {
        log.info("Deleting Restaurant With Id = " + id);
        restaurantService.delete(id);
    }
}
