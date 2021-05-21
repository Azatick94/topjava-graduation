package com.graduation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/db/inmemory/schema-h2.sql", "/db/inmemory/data-h2.sql"})
public abstract class AbstractMockMvcTest {

    protected final String VOTE_HISTORY_REST = "/rest/vote_history";
    protected final String VOTE_REST = "/rest/votes";
    protected final String USER_REST = "/rest/users";

    protected final String SECURITY_USER_LOGIN = "user@mail.ru";
    protected final String SECURITY_ADMIN_LOGIN = "admin@mail.ru";

    protected final String SECURITY_USER_ROLE = "USER";
    protected final String SECURITY_ADMIN_ROLE = "ADMIN";

    @Autowired
    protected MockMvc mockMvc;
}
