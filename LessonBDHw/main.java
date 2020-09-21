package LessonBD;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_url = "jdbc:postgresql://localhost:5432/11-901";


    public static HashSet<Car> addCars(int id, Statement statement) throws SQLException {
        HashSet<Car> cars = new HashSet<Car>();
        ResultSet resultSet = statement.executeQuery("select * from car where driver_id =" + " " + id);
        while (resultSet.next()) {
            cars.add(new Car(resultSet.getInt("id"), resultSet.getString("model"),
                    resultSet.getString("color"), id));
        }
        return cars;

    }


    public static void main(String[] args) {
        Driver driver = null;
        HashSet<Car> cars = null;
        try {
            Connection connection = DriverManager.getConnection(DB_url, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            Scanner s = new Scanner(System.in);
            ResultSet resultSet = statement.executeQuery("select * from driver where id = " + s.nextInt());
            while (resultSet.next()) {
                driver = new Driver(resultSet.getInt("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getInt("age"));
                cars = addCars(driver.getId(), statement);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(driver.toString());
        cars.stream().forEach(car -> {
            System.out.println(car.toString());
        });
    }
}
