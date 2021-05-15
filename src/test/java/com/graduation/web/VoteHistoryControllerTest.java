package com.graduation.web;

import com.graduation.AbstractMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VoteHistoryControllerTest extends AbstractMockMvcTest {

    /**
     * Query VOTE_HISTORY by DATE = 2021-01-01
     */
    @WithMockUser(username = SECURITY_USER_LOGIN, roles = SECURITY_USER_ROLE)
    @Test
    void getByDateTest1() throws Exception {

        this.mockMvc
                .perform(get(VOTE_HISTORY_REST + "/2021-01-01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        content().string(
                                containsString("{\"restaurantId\":100008,\"restaurantName\":\"AnderSon\",\"voteDate\":\"2021-01-01\",\"counts\":1}," +
                                        "{\"restaurantId\":100009,\"restaurantName\":\"Russian Pub\",\"voteDate\":\"2021-01-01\",\"counts\":1}")));
    }

    /**
     * Query VOTE_HISTORY by DATE = 2021-01-03
     */
    @WithMockUser(username = SECURITY_USER_LOGIN, roles = SECURITY_USER_ROLE)
    @Test
    void getByDateNoData() throws Exception {
        this.mockMvc
                .perform(get(VOTE_HISTORY_REST + "/2021-01-03"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(
                        content().string("[]"));
    }
}