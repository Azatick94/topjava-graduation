package com.graduation.web;

import com.graduation.model.Vote;
import com.graduation.to.VoteHistory;
import com.graduation.service.VoteService;
import com.graduation.util.VoteCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/vote_history")
public class VoteHistoryController {

    private final VoteService voteService;

    public VoteHistoryController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public List<VoteHistory> getAll() {
        log.info("Getting All Votes_History");

        // getting List of Votes
        List<Vote> allVotes = voteService.getAll();
        // calculating VoteHistory
        return VoteCalculator.calculateVoteHistory(allVotes);
    }
}
