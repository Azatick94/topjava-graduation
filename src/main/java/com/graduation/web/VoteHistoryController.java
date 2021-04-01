package com.graduation.web;

import com.graduation.model.VoteHistory;
import com.graduation.service.VoteHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/vote_history")
public class VoteHistoryController {

    private final VoteHistoryService voteHistoryService;

    public VoteHistoryController(VoteHistoryService voteHistoryService) {
        this.voteHistoryService = voteHistoryService;
    }

    @GetMapping
    public List<VoteHistory> getAll() {
        log.info("Getting All Votes_History");
        return voteHistoryService.getAll();
    }
}
