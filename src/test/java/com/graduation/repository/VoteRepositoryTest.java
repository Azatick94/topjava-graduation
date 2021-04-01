package com.graduation.repository;

import com.graduation.AbstractTest;
import com.graduation.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VoteRepositoryTest extends AbstractTest {

    @Autowired
    VoteRepository voteRepository;

    @Test
    void getByUserIdAndDate() {
        Vote lst = voteRepository.getByUserIdAndDate(100003, LocalDate.of(2021, 1, 1));
    }
}