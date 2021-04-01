package com.graduation.repository.crud;

import com.graduation.model.VoteHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CrudVoteHistoryRepository extends CrudRepository<VoteHistory, Integer> {

    VoteHistory getById(int id);

    @Modifying
    @Query("DELETE FROM VoteHistory v WHERE v.id=:id")
    int delete(@Param("id") int id);
}
