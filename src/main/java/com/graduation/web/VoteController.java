package com.graduation.web;

import com.graduation.model.Restaurant;
import com.graduation.model.Vote;
import com.graduation.service.VoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public List<Vote> getAll() {
        log.info("Getting All Votes");
        return voteService.getAll();
    }

    @GetMapping("{id}")
    public Vote getById(@PathVariable int id) {
        log.info("Getting Vote By Id: " + id);
        return voteService.getById(id);
    }

    @PostMapping
    public Vote save(@RequestBody Vote vote) {
        log.info("Saving Vote");
        return voteService.save(vote);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Vote vote, @PathVariable int id) {
        log.info("Updating Vote");
        voteService.update(vote, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        log.info("Deleting Vote");
        voteService.delete(id);
    }
}
