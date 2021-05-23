package com.graduation.web;

import com.graduation.AuthUser;
import com.graduation.model.Vote;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.service.VoteService;
import com.graduation.to.VoteTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Votes", description = "Votes API")
@PreAuthorize("isAuthenticated()")
@Slf4j
@RequestMapping("/rest/votes")
public class VoteController {

    private final VoteService voteService;
    private final CrudRestaurantRepository restaurantRepository;

    public VoteController(VoteService voteService, CrudRestaurantRepository restaurantRepository) {
        this.voteService = voteService;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("by/id")
    @Operation(summary = "Get Vote By Id")
    @PreAuthorize("hasRole('ADMIN')")
    public Vote getById(@RequestParam Integer id) {
        log.info("Getting Vote With Id: " + id);
        return voteService.getById(id);
    }

    @GetMapping("by/date")
    @Operation(summary = "Get All Votes By Date")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Vote> getByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("Getting All Votes By Date");
        return voteService.getByDate(date);
    }

    @GetMapping("user_votes")
    @Operation(summary = "Get Authorized User Votes")
    @PreAuthorize("hasRole('USER')")
    public List<Vote> getAuthVotes() {
        log.info("Getting Vote of Authorized User");
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = authUser.getUser().getId();
        return voteService.getByUserId(userId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save/Update Vote")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<URI> save(@Valid @RequestBody VoteTo voteTo) {
        log.info("Saving/Updating Vote");
        return voteService.saveUpdate(voteTo);
    }
}
