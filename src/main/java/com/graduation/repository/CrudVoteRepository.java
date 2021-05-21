package com.graduation.repository;

import com.graduation.model.Vote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CrudVoteRepository extends CrudRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.voteDateTime >= :startDateTime AND v.voteDateTime <= :endDateTime")
    List<Vote> getBetweenDatesIncluding(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    @Query("SELECT v FROM Vote v WHERE v.voteDate=:voteDate AND v.userId=:userId")
    Vote getByUserIdAndDate(@Param("userId") Integer userId, @Param("voteDate") LocalDate voteDate);

    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    Integer delete(@Param("id") Integer id);

    @Query(value = "SELECT RESTAURANT_ID, RESTAURANT_NAME, VOTE_DATE, COUNT(RESTAURANT_ID) AS COUNTS FROM VOTES v LEFT JOIN RESTAURANTS r ON v.RESTAURANT_ID = r.ID\n" +
            "WHERE VOTE_DATE=:date\n" +
            "GROUP BY RESTAURANT_ID, VOTE_DATE\n" +
            "HAVING COUNTS = (\n" +
            "    SELECT MAX(COUNT)\n" +
            "    FROM (\n" +
            "             SELECT COUNT(RESTAURANT_ID) AS COUNT\n" +
            "             FROM VOTES\n" +
            "             WHERE VOTE_DATE=:date\n" +
            "             GROUP BY RESTAURANT_ID))" +
            "ORDER BY VOTE_DATE DESC, COUNTS DESC",
            nativeQuery = true)
    List<Object[]> getVoteWinnersByDate(@Param("date") String date);


    @Query(value = "SELECT RESTAURANT_ID, RESTAURANT_NAME, VOTE_DATE, COUNT(RESTAURANT_ID) AS COUNTS FROM VOTES v" +
            " LEFT JOIN RESTAURANTS r ON v.RESTAURANT_ID = r.ID\n" +
            "GROUP BY VOTE_DATE, RESTAURANT_ID\n" +
            "ORDER BY VOTE_DATE DESC, COUNTS DESC",
            nativeQuery = true)
    List<Object[]> getAllGroupedVoteResults();


}