package com.graduation.repository;

import com.graduation.model.VoteHistory;
import com.graduation.repository.crud.CrudVoteHistoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VoteHistoryRepository implements BaseRepository<VoteHistory> {

    private final CrudVoteHistoryRepository voteHistoryRepository;

    public VoteHistoryRepository(CrudVoteHistoryRepository voteHistoryRepository) {
        this.voteHistoryRepository = voteHistoryRepository;
    }

    @Override
    public List<VoteHistory> getAll() {
        return (List<VoteHistory>) voteHistoryRepository.findAll();
    }

    @Override
    public VoteHistory getById(int id) {
        return voteHistoryRepository.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        voteHistoryRepository.delete(id);
    }

    @Override
    @Transactional
    public VoteHistory create(VoteHistory vote) {
        return voteHistoryRepository.save(vote);
    }

    @Override
    @Transactional
    public void update(VoteHistory vote, int id) {
        vote.setId(id);
        voteHistoryRepository.save(vote);
    }
}
