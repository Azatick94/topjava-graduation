package com.graduation.web;

import com.graduation.model.Restaurant;
import com.graduation.service.RestaurantService;
import com.graduation.to.RestaurantTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Restaurants", description = "Restaurants API")
@PreAuthorize("isAuthenticated()")
@Slf4j
@RequestMapping("/rest/restaurants")
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
    public ResponseEntity<URI> save(@Valid @RequestBody RestaurantTo restaurantTo) {
        log.info("Saving restaurant");
        Restaurant restaurant = restaurantService.save(restaurantTo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restaurant.getId()).toUri();
        return new ResponseEntity<>(uri, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update Existing Restaurant By Id")
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody RestaurantTo restaurantTo, @PathVariable int id) {
        log.info("Updating Restaurant With Id = " + id);
        restaurantService.update(restaurantTo, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Restaurant By Id")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        log.info("Deleting Restaurant With Id = " + id);
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
