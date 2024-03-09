package org.example.jpa.jdbcOnly;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTestRunner {



    @Test
    protected void test1() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "Slqlrjf12#$";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String dropTableQuery = "DROP TABLE IF EXISTS users;";

        String createTableQuery = "CREATE TABLE users (\n" +
                "    user_id INT PRIMARY KEY,\n" +
                "    last_name VARCHAR(50),\n" +
                "    first_name VARCHAR(50)\n" +
                ");";

        String createIndexQuery = "CREATE INDEX idx_last_name ON users(last_name);\n";
        String insertQuery = "INSERT INTO users (user_id, last_name, first_name) VALUES (100, 'Smith', 'fuck');";
        String findUserData = "SELECT * FROM users WHERE last_name = 'Smith';\n";

        Statement stmt = connection.createStatement();
        stmt.execute(dropTableQuery);
        stmt.execute(createTableQuery);
        stmt.execute(createIndexQuery);
        stmt.execute(insertQuery);
        ResultSet rs = stmt.executeQuery(findUserData);

        while(rs.next()){
            System.out.println(rs.getString("last_name"));
        }

        rs.close();
        stmt.close();
        connection.close();
    }



}
