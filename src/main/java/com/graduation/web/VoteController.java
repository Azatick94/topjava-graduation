package com.graduation.web;

import com.graduation.model.User;
import com.graduation.model.Vote;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.repository.CrudUserRepository;
import com.graduation.service.VoteService;
import com.graduation.to.VoteTo;
import com.graduation.util.exception.CustomMessageException;
import com.graduation.util.exception.IdNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Tag(name = "Votes", description = "Votes API")
@PreAuthorize("isAuthenticated()")
@Slf4j
@RequestMapping("/rest/votes")
public class VoteController {

    private final VoteService voteService;
    private final CrudUserRepository userRepository;
    private final CrudRestaurantRepository restaurantRepository;

    public VoteController(VoteService voteService, CrudUserRepository userRepository, CrudRestaurantRepository restaurantRepository) {
        this.voteService = voteService;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    @Cacheable(value = "votes")
    @Operation(summary = "Get All Votes")
    public List<Vote> getAll() {
        log.info("Getting All Votes");
        return voteService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Vote By Id")
    public Vote getById(@PathVariable Integer id) {
        log.info("Getting Vote With Id: " + id);
        return voteService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save/Update Vote")
    @PreAuthorize("hasRole('USER')")
    @CacheEvict(value = "votes", allEntries = true)
    public Vote save(@Valid @RequestBody VoteTo voteTo, Principal principal) {
        log.info("Saving/Updating Vote");

        // check restaurantId presence in DB
        Integer restaurantId = voteTo.getRestaurantId();
        restaurantRepository.findById(restaurantId).orElseThrow(() -> new IdNotFoundException(restaurantId));

        // getting Email of logged person
        String userEmail = principal.getName();
        User userByEmail = userRepository.findByEmailIgnoreCase(userEmail).orElse(null);

        if (userByEmail == null) {
            throw new CustomMessageException("Authorization Problems");
        } else {
            Integer userId = userByEmail.getId();

            LocalDate voteDate = voteTo.getVoteDateTime().toLocalDate();
            // get vote from DB by User and Date
            Vote voteFromDb = voteService.getByUserIdAndDate(userId, voteDate);

            if (voteFromDb == null) {
                return voteService.save(voteTo, userId);
            } else {
                LocalTime time = voteTo.getVoteDateTime().toLocalTime();
                if (time.isAfter(LocalTime.of(11, 0, 0))) {
                    throw new CustomMessageException("Vote can't be updated because User can't change his decision after 11 a.m.");
                } else {
                    return voteService.update(voteTo, userId, voteFromDb.getId());
                }
            }
        }
    }
}
