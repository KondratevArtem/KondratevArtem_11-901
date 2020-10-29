package my.servlet.servlets;

import lombok.SneakyThrows;
import my.servlet.models.User;
import my.servlet.repositories.UsersRepository;
import my.servlet.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;


@WebServlet("/users_table")
public class UsersServlet extends HttpServlet {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_url = "jdbc:postgresql://localhost:5432/servlet";

    private UsersRepository usersRepository;

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        usersRepository = new UsersRepositoryJdbcImpl(DriverManager.getConnection(DB_url, DB_USERNAME, DB_PASSWORD));
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        request.setAttribute("usersForJsp", users);
        request.getRequestDispatcher("WEB-INF/jsp/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
