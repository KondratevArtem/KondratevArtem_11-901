package my.servlet.repositories;

import my.servlet.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jdk.nashorn.internal.runtime.Debug.id;

public class UsersRepositoryJdbcImpl implements UsersRepository {



    //language=SQL
    private static final String SQL_FIND_ALL_USERS = "select * from users";

    //language=SQL
    private static final String SQL_FIND_ALL_USERS_BY_NAME
            = "select * from users where first_name like ?";

    private Connection connection;
    SimpleJdbcTemplate simpleJdbc;
    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        simpleJdbc = new SimpleJdbcTemplate(connection);
    }


    @Override
    public List<User> findAllByAge() {
        return null;
    }

    private final RowMapper<User> userRowMapper = row -> User.builder()
            .firstName(row.getString("first_name"))
            .lastName(row.getString("last_name"))
            .age(row.getInt("age"))
            .build();

    @Override
    public Boolean findUser(String email, String password) {
        try {
            Statement statement = connection.createStatement();
            //language=SQL
            String sql = "select * from users where email = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAllByNameStartingWith(String name) {
        return simpleJdbc.queryForList(SQL_FIND_ALL_USERS_BY_NAME, userRowMapper, "%" + name + "%");
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(userRowMapper.mapRow(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void addCookie(String email, String uuid) {
        try {
            Class.forName("org.postgresql.Driver");
            String sql = "update users " +
                    "set uuid = ? where email = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteDyId(Long id) {

    }
}
