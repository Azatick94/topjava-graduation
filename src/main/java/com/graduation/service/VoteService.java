package com.graduation.service;

import com.graduation.model.Vote;
import com.graduation.repository.VoteRepository;
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

    public Vote getByUserId(int userId) {
        return voteRepository.getByUserId(userId);
    }

    public Vote getByUserIdAndDate(int userID, LocalDate date) {
        return voteRepository.getByUserIdAndDate(userID, date);
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public void delete(int id) {
        voteRepository.delete(id);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
