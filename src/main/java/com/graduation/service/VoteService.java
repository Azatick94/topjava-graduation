package com.graduation.service;

import com.graduation.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VoteService {
    Vote save(Vote vote);

    boolean delete(int voteId);

    Vote getByVoteId(int voteId);

    List<Vote> getAll();

    List<Vote> getBetweenDatesIncluding(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
