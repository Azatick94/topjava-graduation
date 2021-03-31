package com.graduation.service;

import com.graduation.model.Vote;
import com.graduation.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService implements BaseService<Vote> {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    @Override
    public Vote getById(int id) {
        return null;
//        return voteRepository.getByVoteId(id);
    }

    @Override
    public Vote save(Vote vote) {
        return null;
//        return voteRepository.save(vote);
    }

    @Override
    public void update(Vote vote, int id) {
//        voteRepository.save(vote);
    }

    @Override
    public void delete(int id) {
        voteRepository.delete(id);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}