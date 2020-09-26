package my.servlet;


import db.myDB;
import lombok.SneakyThrows;
import my.servlet.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/users_table")
public class UsersServlet extends HttpServlet {

    public static List<User> getUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        ResultSet resultSet = myDB.getUser();
        while (resultSet.next()) {
            users.add(new User((long)(resultSet.getInt("id")), resultSet.getString("first_name"),
                    resultSet.getString("last_name"), resultSet.getInt("age"),
                    resultSet.getString("email")));
        }
        return users;
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usersForJsp", getUsers());
        request.getRequestDispatcher("WEB-INF/jsp/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
