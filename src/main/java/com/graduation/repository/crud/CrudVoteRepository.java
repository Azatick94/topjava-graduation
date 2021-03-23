package com.graduation.repository.crud;

import com.graduation.model.Vote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudVoteRepository extends CrudRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.voteDate >= :startDateTime AND v.voteDate <= :endDateTime")
    List<Vote> getBetweenDatesIncluding(@Param("startDateTime") LocalDateTime startDate, @Param("endDateTime") LocalDateTime endDate);

    Vote getByVoteId(int lunchId);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.voteId=:vote_id")
    int delete(@Param("vote_id") int voteId);
}
