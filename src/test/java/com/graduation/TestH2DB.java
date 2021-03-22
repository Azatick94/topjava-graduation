package com.graduation;

import java.sql.*;

/**
 * class to check that h2-DATABASE works fine and it's possible to run Queries
 */
public class TestH2DB {

    private static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS EXAMPLE (GREETING VARCHAR(6), TARGET VARCHAR(6))";
    private static final String DROP_QUERY = "DROP TABLE IF EXISTS EXAMPLE";
    private static final String DATA_QUERY = "INSERT INTO EXAMPLE VALUES('Hello','World')";

    // inmemory realization
//    private static final String connectionInfo = "jdbc:h2:mem:";
    private static final String connectionInfo = "jdbc:h2:tcp://localhost/~/test";

    private TestH2DB() {
    }

    public static void main(String[] args) {
//        "jdbc:h2:mem:"
        try (Connection db = DriverManager.getConnection(connectionInfo, "", "")) {
            try (Statement dataQuery = db.createStatement()) {
                dataQuery.execute(DROP_QUERY);
                dataQuery.execute(CREATE_QUERY);
                dataQuery.execute(DATA_QUERY);
            }

            try (PreparedStatement query =
                         db.prepareStatement("SELECT * FROM EXAMPLE")) {
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    System.out.printf("%s, %s!%n",
                            rs.getString(1),
                            rs.getString("TARGET"));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
}
