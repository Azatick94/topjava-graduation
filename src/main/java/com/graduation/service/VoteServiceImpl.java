package com.graduation.service;

import com.graduation.model.Vote;
import com.graduation.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public boolean delete(int voteId) {
        return voteRepository.delete(voteId);
    }

    @Override
    public Vote getByVoteId(int voteId) {
        return voteRepository.getByVoteId(voteId);
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.getAll();
    }

    @Override
    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
