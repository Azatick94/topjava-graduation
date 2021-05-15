package com.graduation.web;

import com.graduation.AbstractMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends AbstractMockMvcTest {

    /**
     * Get All Users Logging as Admin. Should be Successful result
     *
     */
    @WithMockUser(username = SECURITY_ADMIN_LOGIN, roles = SECURITY_ADMIN_ROLE)
    @Test
    void getAllAdminTest() throws Exception {
        this.mockMvc
                .perform(get(USER_REST))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Get All Users Logging as USER. Should be Security Exception
     *
     */
    @WithMockUser(username = SECURITY_USER_LOGIN, roles = SECURITY_USER_ROLE)
    @Test
    void getAllUserTest() throws Exception {
        this.mockMvc
                .perform(get(USER_REST))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}