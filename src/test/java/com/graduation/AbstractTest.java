package com.graduation;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest
@Sql(scripts = "classpath:db/local_sql/data_local.sql", config = @SqlConfig(encoding = "UTF-8"))
abstract public class AbstractTest {
}
