package com.graduation.repository.crud;

import com.graduation.model.Vote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CrudVoteRepository extends CrudRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.voteDateTime >= :startDateTime AND v.voteDateTime <= :endDateTime")
    List<Vote> getBetweenDatesIncluding(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    Vote getById(int id);

    Vote getByUserId(int userId);

    @Query("SELECT v FROM Vote v WHERE v.voteDate=:voteDate AND v.userId=:userId")
    Vote getByUserIdAndDate(@Param("userId") Integer userId, @Param("voteDate") LocalDate voteDate);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);
}
