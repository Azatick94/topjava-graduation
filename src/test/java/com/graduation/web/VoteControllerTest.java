package com.graduation.web;

import com.graduation.AbstractMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

class VoteControllerTest extends AbstractMockMvcTest {

    @WithMockUser(username = SECURITY_USER_LOGIN, roles = SECURITY_USER_ROLE)
    @Test
    void getByIdUserTest() throws Exception {
        this.mockMvc
                .perform(get(VOTE_REST + "/by/id?id=100034"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @WithMockUser(username = SECURITY_ADMIN_LOGIN, roles = SECURITY_ADMIN_ROLE)
    @Test
    void getByIdAdminTest() throws Exception {
        this.mockMvc
                .perform(get(VOTE_REST + "/by/id?id=100034"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":100034,\"userId\":100001,\"restaurantId\":100008")));
    }
}