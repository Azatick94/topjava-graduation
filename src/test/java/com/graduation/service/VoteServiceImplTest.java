package com.graduation.service;

import com.graduation.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VoteServiceImplTest extends AbstractServiceTest {

    @Autowired
    VoteService voteService;

    @Test
    void saveNewVoteTest() {
//        TODO
//        Vote newVote = new Vote();
//        newVote.setVoteDate(LocalDateTime.MAX);

//        Vote expectedLunch = new Vote(100036, LocalDate.of(2021, 1, 1), "Test Lunch", 100, restaurantService.getByName("AnderSon"));
//        Vote savedLunch = voteService.save(newVote);
//        System.out.println();
//        assertThat(savedLunch).isEqualTo(expectedLunch);
    }
//
//    @Test
//    void updateVoteTest() {
//        Vote newVote = voteService.getByVoteId(100033);
//        newVote.setVoteDate(LocalDateTime.MIN);
//
//        Vote expectedVote = new Vote(100033, 100003, 100009, LocalDateTime.MIN);
//        Vote updatedVote = voteService.save(newVote);
//
//        assertThat(updatedVote).isEqualTo(expectedVote);
//    }
//
//    @Test
//    void deleteTest() {
//        voteService.delete(100032);
//        assertNull(voteService.getByVoteId(100032));
//    }
//
//    @Test
//    void getAllTest() {
//        List<Vote> votes = voteService.getAll();
//        assertEquals(votes.size(), 4);
//    }
//
//    @Test
//    void getBetweenDatesIncluding() {
//        List<Vote> votesBetweenDates = voteService.getBetweenDatesIncluding(LocalDateTime.of(2021, 1, 1,0,0),
//                LocalDateTime.of(2021, 1, 2,0,0));
//        assertEquals(votesBetweenDates.size(), 3);
//    }
}
