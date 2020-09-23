package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class myDB {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_url = "jdbc:postgresql://localhost:5432/servlet";

    public static void addUser(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_url, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users(email, password) values " + "('" + email + "', '"
                    + password + "');");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
