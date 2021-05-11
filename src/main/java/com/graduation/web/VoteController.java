package com.graduation.web;

import com.graduation.model.User;
import com.graduation.model.Vote;
import com.graduation.repository.crud.CrudUserRepository;
import com.graduation.service.VoteService;
import com.graduation.to.VoteTo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/vote")
public class VoteController {

    private final VoteService voteService;

    private final CrudUserRepository userRepository;

    public VoteController(VoteService voteService, CrudUserRepository userRepository) {
        this.voteService = voteService;
        this.userRepository = userRepository;
    }

    @GetMapping
    @Operation(summary = "Get All Votes")
    public List<Vote> getAll() {
        log.info("Getting All Votes");
        return voteService.getAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get Vote By Id")
    public Vote getById(@PathVariable int id) {
        log.info("Getting Vote By Id: " + id);
        return voteService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save/Update Vote")
    @PreAuthorize("hasRole('USER')")
    public Vote save(@RequestBody VoteTo voteTo, Principal principal) {
        log.info("Saving/Updating Vote");

        String userEmail = principal.getName();
        User userByEmail = userRepository.findByEmailIgnoreCase(userEmail).orElse(null);

        if (userByEmail == null) {
            return null;
        } else {
            Integer userId = userByEmail.getId();

            LocalDate voteDate = voteTo.getVoteDateTime().toLocalDate();
            // get vote from DB by User and Date
            Vote voteFromDb = voteService.getByUserIdAndDate(userId, voteDate);

            if (voteFromDb == null) {
                log.info("Saving vote");
                return voteService.save(voteTo, userId);
            } else {
                LocalTime time = voteTo.getVoteDateTime().toLocalTime();
                if (time.isAfter(LocalTime.of(11, 0, 0))) {
                    log.info("Vote wasn't updated because User can't change his decision after 11 a.m.");
                    return null;
                } else {
                    log.info("Vote was updated");
                    return voteService.update(voteTo, userId, voteFromDb.getId());
                }
            }
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete Vote By Id")
    public void delete(@PathVariable int id) {
        log.info("Deleting Vote");
        voteService.delete(id);
    }
}
