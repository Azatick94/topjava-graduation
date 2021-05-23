package com.graduation.repository;

import com.graduation.model.Vote;
import com.graduation.to.VotingResultsTo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CrudVoteRepository extends CrudRepository<Vote, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.voteDate=:voteDate")
    List<Vote> getByDate(@Param("voteDate") LocalDate voteDate);

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.voteDateTime >= :startDateTime AND v.voteDateTime <= :endDateTime")
    List<Vote> getBetweenDatesIncluding(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.userId=:userId")
    List<Vote> getByUserId(@Param("userId") Integer userId);

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.voteDate=:voteDate AND v.userId=:userId")
    Vote getByUserIdAndDate(@Param("userId") Integer userId, @Param("voteDate") LocalDate voteDate);

    @Transactional(readOnly = true)
    @Query("SELECT NEW com.graduation.to.VotingResultsTo(v.restaurantId, v.restaurant.restaurantName, v.voteDate, COUNT(v.restaurantId)) FROM Vote v " +
            "WHERE v.voteDate=:date " +
            "GROUP BY v.restaurantId ORDER BY v.voteDate DESC")
    List<VotingResultsTo> getVoteWinnersByDate(@Param("date") LocalDate date);
}
