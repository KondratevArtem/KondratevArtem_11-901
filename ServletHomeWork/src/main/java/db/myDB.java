package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class myDB {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_url = "jdbc:postgresql://localhost:5432/servlet";

    public static void addUser(String firstName, String lastName, String age, String email, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_url, DB_USERNAME, DB_PASSWORD);
            Class.forName("org.postgresql.Driver");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users(first_name, last_name, age, email, password) " +
                    "values " + "('" + firstName + "', '" + lastName + "', " + age + ", '"
                    + email + "', '" + password + "');");

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getUser() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(DB_url, DB_USERNAME, DB_PASSWORD);
        Class.forName("org.postgresql.Driver");
        Statement statement = connection.createStatement();
        return statement.executeQuery("select * from users");
    }

}
