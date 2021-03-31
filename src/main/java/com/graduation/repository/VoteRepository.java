package com.graduation.repository;

import com.graduation.model.Vote;
import com.graduation.repository.crud.CrudVoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository implements BaseRepository<Vote> {

    private final CrudVoteRepository voteRepository;

    public VoteRepository(CrudVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> getAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    @Override
    public Vote getById(int id) {
        return voteRepository.getByVoteId(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        voteRepository.delete(id);
    }

    @Override
    @Transactional
    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    public void update(Vote vote, int id) {
        vote.setVoteId(id);
        voteRepository.save(vote);
    }

    public List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return voteRepository.getBetweenDatesIncluding(startDateTime, endDateTime);
    }
}
