package com.graduation.service;

import com.graduation.model.Vote;
import com.graduation.repository.VoteRepository;
import com.graduation.to.VoteTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    public Vote getById(int id) {
        return voteRepository.getById(id);
    }

    public Vote getByUserIdAndDate(int userID, LocalDate date) {
        return voteRepository.getByUserIdAndDate(userID, date);
    }

    public Vote save(VoteTo voteTo, Integer userId) {
        Vote vote = new Vote(null, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        return voteRepository.save(vote);
    }

    public Vote update(VoteTo voteTo, Integer userId, Integer voteId) {
        Vote vote = new Vote(voteId, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        return voteRepository.save(vote);
    }

    public void delete(int id) {
        voteRepository.delete(id);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
