package com.graduation.service;

import com.graduation.model.Restaurant;
import com.graduation.model.Vote;
import com.graduation.repository.CrudVoteRepository;
import com.graduation.to.VotingResultsTo;
import com.graduation.to.VoteTo;
import com.graduation.util.Converters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.graduation.util.MainUtil.findByIdThrowExceptionIfNotFound;

@Service
public class VoteService {

    private final CrudVoteRepository crudRepo;

    public VoteService(CrudVoteRepository crudVoteRepository) {
        this.crudRepo = crudVoteRepository;
    }

    public List<Vote> getByDate(LocalDate date) {
        return crudRepo.getByDate(date);
    }

    public Vote getById(Integer id) {
        return findByIdThrowExceptionIfNotFound(crudRepo, id);
    }

    public Vote getByUserIdAndDate(Integer userID, LocalDate date) {
        return crudRepo.getByUserIdAndDate(userID, date);
    }

    public List<VotingResultsTo> getVoteWinnersByDate(LocalDate date) {
        return crudRepo.getVoteWinnersByDate(date);
    }

    public List<VotingResultsTo> getAllGroupedVoteResults() {
        List<Object[]> result = crudRepo.getAllGroupedVoteResults();
        return Converters.ObjectToVotingResultsTo(result);
    }

    @Transactional
    public Vote save(VoteTo voteTo, Integer userId) {
        Vote vote = new Vote(null, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        vote.setRestaurant(new Restaurant(voteTo.getRestaurantId(), ""));
        return crudRepo.save(vote);
    }

    @Transactional
    public Vote update(VoteTo voteTo, Integer userId, Integer voteId) {
        Vote vote = new Vote(voteId, userId, voteTo.getRestaurantId(), voteTo.getVoteDateTime());
        vote.setRestaurant(new Restaurant(voteTo.getRestaurantId(), ""));
        return crudRepo.save(vote);
    }
}
