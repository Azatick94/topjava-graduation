package com.graduation.web;

import com.graduation.service.VoteService;
import com.graduation.to.VotingResultsTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Voting Results", description = "Voting Results API")
@PreAuthorize("isAuthenticated()")
@Slf4j
@RequestMapping("/rest/vote_history")
public class VoteHistoryController {

    private final VoteService voteService;

    public VoteHistoryController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    @Operation(summary = "Get Restaurant Voting Results")
    public List<VotingResultsTo> getAll() {
        log.info("Getting All Votes Results");
        return voteService.getAllGroupedVoteResults();
    }

    @GetMapping("{date}")
    @Operation(summary = "Get Restaurant Voting Results by Certain Date")
    public List<VotingResultsTo> getByDate(@PathVariable String date) {
        log.info("Getting Voting Results by Date = " + date);
        return voteService.getVoteWinnersByDate(date);
    }
}
