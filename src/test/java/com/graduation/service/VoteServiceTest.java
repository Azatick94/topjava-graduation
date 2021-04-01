package com.graduation.service;

import com.graduation.AbstractTest;
import com.graduation.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VoteServiceTest extends AbstractTest {

    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    RestaurantService restaurantService;

    @Test
    void saveNewVoteTest() {
        Vote newVote = new Vote();
        newVote.setUserId(userService.getByName("Azat").get(0).getId());
        newVote.setRestaurantId(restaurantService.getByName("AnderSon").getId());
        newVote.setVoteDateTime(LocalDateTime.MAX);

        // saving Vote
        Vote savedVote = voteService.save(newVote);
        assertThat(newVote).isEqualTo(savedVote);
    }

    @Test
    void updateVoteTest() {
        Vote voteToUpdate = new Vote(100032, 100002, 100010, LocalDateTime.of(2199, 1, 1, 10, 0));

        // updating Vote
        Vote updatedVote = voteService.save(voteToUpdate);
        assertThat(updatedVote).isEqualTo(updatedVote);
    }

    @Test
    void deleteTest() {
        voteService.delete(100032);
        assertNull(voteService.getById(100032));
    }

    @Test
    void getAllTest() {
        List<Vote> votes = voteService.getAll();
        assertEquals(votes.size(), 4);
    }

    @Test
    void getBetweenDatesIncluding() {
        List<Vote> votesBetweenDates = voteService.getBetweenDatesIncluding(LocalDateTime.of(2021, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 2, 0, 0));
        assertEquals(votesBetweenDates.size(), 3);
    }
}
