package com.graduation.repository.crud;

import com.graduation.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudUserRepository extends CrudRepository<User, Integer> {
    List<User> findByName(String name);

    @Modifying
    @Query("DELETE FROM User u WHERE u.userId=:id")
    int delete(@Param("id") int id);
}
