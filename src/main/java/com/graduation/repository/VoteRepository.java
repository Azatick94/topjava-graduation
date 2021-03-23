package com.graduation.repository;

import com.graduation.model.Vote;
import com.graduation.repository.crud.CrudVoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository {

    private final CrudVoteRepository voteRepository;

    public VoteRepository(CrudVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Transactional
    public Vote save(Vote vote) {
        if (vote == null) {
            return null;
        }
        return voteRepository.save(vote);
    }

    @Transactional
    public boolean delete(int lunchId) {
        return voteRepository.delete(lunchId) != 0;
    }

    public Vote getByVoteId(int voteId) {
        return voteRepository.getByVoteId(voteId);
    }

    public List<Vote> getAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
