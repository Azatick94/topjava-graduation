package com.graduation.repository;

import com.graduation.model.Vote;
import com.graduation.repository.crud.CrudVoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository {

    private final CrudVoteRepository voteRepository;

    public VoteRepository(CrudVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    public Vote getById(int id) {
        return voteRepository.getById(id);
    }

    public Vote getByUserId(int userId) {
        return voteRepository.getByUserId(userId);
    }

    public Vote getByUserIdAndDate(int userId, LocalDate date) {
        return voteRepository.getByUserIdAndDate(userId, date);
    }

    @Transactional
    public void delete(int id) {
        voteRepository.delete(id);
    }

    @Transactional
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
