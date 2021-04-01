package com.graduation.service;

import com.graduation.model.VoteHistory;
import com.graduation.repository.VoteHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteHistoryService implements BaseService<VoteHistory> {

    private final VoteHistoryRepository voteHistoryRepository;

    public VoteHistoryService(VoteHistoryRepository voteHistoryRepository) {
        this.voteHistoryRepository = voteHistoryRepository;
    }

    @Override
    public List<VoteHistory> getAll() {
        return voteHistoryRepository.getAll();
    }

    @Override
    public VoteHistory getById(int id) {
        return voteHistoryRepository.getById(id);
    }

    @Override
    public VoteHistory save(VoteHistory voteHistory) {
        return voteHistoryRepository.create(voteHistory);
    }

    @Override
    public void update(VoteHistory voteHistory, int id) {
        voteHistoryRepository.update(voteHistory, id);
    }

    @Override
    public void delete(int id) {
        voteHistoryRepository.delete(id);
    }

}
