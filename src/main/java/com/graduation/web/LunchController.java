package com.graduation.web;

import com.graduation.model.Lunch;
import com.graduation.service.LunchService;
import com.graduation.to.LunchTo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/lunch")
public class LunchController {

    private final LunchService lunchService;

    public LunchController(LunchService lunchService) {
        this.lunchService = lunchService;
    }

    @GetMapping
    @Operation(summary = "Get All Lunches")
    public List<Lunch> getAll() {
        log.info("Getting All Lunches");
        return lunchService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Lunch By Id")
    public Lunch getById(@PathVariable int id) {
        log.info("Getting Lunch By Id: " + id);
        return lunchService.getById(id);
    }

    @GetMapping("/by_restaurant/{name}")
    @Operation(summary = "Get List of Lunches By RestaurantName")
    public List<Lunch> getByRestaurantName(@PathVariable String name) {
        log.info("Getting Lunch By Name: " + name);
        return lunchService.getByRestaurantName(name);
    }

    @GetMapping("/filter")
    @Operation(summary = "Get List of Lunches Between Dates")
    public List<Lunch> getBetweenDatesIncluding(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        log.info("Getting Lunch Between Dates");
        return lunchService.getBetweenDatesIncluding(startDate, endDate);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Save New Lunch")
    public Lunch save(@RequestBody LunchTo lunchTo) {
        log.info("Saving Lunch");
        return lunchService.save(lunchTo);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update Existing Lunch")
    public void update(@RequestBody LunchTo lunchTo, @PathVariable int id) {
        log.info("Updating Lunch");
        lunchService.update(lunchTo, id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Lunch By Id")
    public void delete(@PathVariable int id) {
        log.info("Deleting Lunch");
        lunchService.delete(id);
    }
}
