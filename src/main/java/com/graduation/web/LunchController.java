package com.graduation.web;

import com.graduation.model.Lunch;
import com.graduation.service.LunchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
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
    public List<Lunch> getAll() {
        log.info("Getting All Lunches");
        return lunchService.getAll();
    }

    @GetMapping("{id}")
    public Lunch getById(@PathVariable int id) {
        log.info("Getting Lunch By Id: " + id);
        return lunchService.getById(id);
    }

    @GetMapping("/by_restaurant/{name}")
    public List<Lunch> getByRestaurantName(@PathVariable String name) {
        log.info("Getting Lunch By Name: " + name);
        return lunchService.getByRestaurantName(name);
    }

    @GetMapping("/filter")
    public List<Lunch> getBetweenDatesIncluding(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        log.info("Getting Lunch Between Dates");
        return lunchService.getBetweenDatesIncluding(startDate, endDate);
    }

    @PostMapping
    public Lunch save(@RequestBody Lunch lunch) {
        log.info("Saving Lunch");
        return lunchService.save(lunch);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Lunch lunch, @PathVariable int id) {
        log.info("Updating Lunch");
        lunchService.update(lunch, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        log.info("Deleting Lunch");
        lunchService.delete(id);
    }
}
