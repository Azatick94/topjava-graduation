package com.graduation.web;

import com.graduation.AuthUser;
import com.graduation.model.Vote;
import com.graduation.repository.CrudRestaurantRepository;
import com.graduation.service.VoteService;
import com.graduation.to.VoteTo;
import com.graduation.util.exception.CustomMessageException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

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
    @PreAuthorize("hasRole('User')")
    public List<Vote> getAuthVotes() {
        log.info("Getting Vote of Authorized User");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = (AuthUser) auth.getPrincipal();
        Integer userId = authUser.getUser().getId();
        return voteService.getByUserId(userId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save/Update Vote")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<URI> save(@Valid @RequestBody VoteTo voteTo) {
        log.info("Saving/Updating Vote");

        // check restaurantId presence in DB
        Integer restaurantId = voteTo.getRestaurantId();
        findByIdThrowExceptionIfNotFound(restaurantRepository, restaurantId);

        // https://stackoverflow.com/questions/31159075/how-to-find-out-the-currently-logged-in-user-in-spring-boot
        // https://stackoverflow.com/questions/22678891/how-to-get-user-id-from-customuser-on-spring-security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthUser authUser = (AuthUser) auth.getPrincipal();
        Integer userId = authUser.getUser().getId();

        LocalDate voteDate = voteTo.getVoteDateTime().toLocalDate();
        // get vote from DB by User and Date
        Vote voteFromDb = voteService.getByUserIdAndDate(userId, voteDate);

        if (voteFromDb == null) {
            Vote vote = voteService.save(voteTo, userId);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri();
            return new ResponseEntity<>(uri, HttpStatus.CREATED);
        } else {
            LocalTime time = voteTo.getVoteDateTime().toLocalTime();
            if (time.isAfter(LocalTime.of(11, 0, 0))) {
                throw new CustomMessageException("Vote can't be updated because User can't change his decision after 11 a.m.");
            } else {
                voteService.update(voteTo, userId, voteFromDb.getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }
}
