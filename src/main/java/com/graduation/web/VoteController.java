package com.graduation.web;

import com.graduation.model.Vote;
import com.graduation.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary="Get All Votes")
    public List<Vote> getAll() {
        log.info("Getting All Votes");
        return voteService.getAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary="Get Vote By Id")
    public Vote getById(@PathVariable int id) {
        log.info("Getting Vote By Id: " + id);
        return voteService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Save New Vote")
    public Vote save(@RequestBody Vote vote) {
        log.info("Saving Vote");

        Integer voteUserId = vote.getUserId();
        LocalDate voteDate = vote.getVoteDateTime().toLocalDate();

        // get vote from DB by User and Date
        Vote voteFromDb = voteService.getByUserIdAndDate(voteUserId, voteDate);

        // did user vote?
        if (voteFromDb == null) { // User didn't vote
            return voteService.save(vote);
        } else {
            // TODO
            // custom message. it is not saving, but updating
            return null;
        }
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary="Update Existing Vote")
    public Vote update(@RequestBody Vote vote, @PathVariable Integer id) {
        log.info("Updating Vote");

        Vote voteFromDb = voteService.getById(id);

        // did user vote?
        if (voteFromDb == null) {
            // TODO
            // User didn't vote, it is not updating, it is saving
            return null;
        } else {
            LocalTime time = vote.getVoteDateTime().toLocalTime();
            if (time.isAfter(LocalTime.of(11, 0, 0))) {
                // TODO some custom message here
                // After 11. Too late, User can't change his decision
                return null;
            } else {
                // Before 11. User decided to change his mind
                vote.setId(id);
                return voteService.save(vote);
            }
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary="Delete Vote By Id")
    public void delete(@PathVariable int id) {
        log.info("Deleting Vote");
        voteService.delete(id);
    }
}
