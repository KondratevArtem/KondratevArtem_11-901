package my.servlet.servlets;

import lombok.SneakyThrows;
import my.servlet.repositories.UsersRepository;
import my.servlet.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.UUID;

@WebServlet("")
public class LoginServlet extends HttpServlet {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/servlet";

    private UsersRepository usersRepository;

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        usersRepository = new UsersRepositoryJdbcImpl(DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/html/login_page.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (usersRepository.findUser(request.getParameter("email"), request.getParameter("password"))) {
            Cookie cookie = new Cookie("cookieLogin", UUID.randomUUID().toString());
            usersRepository.addCookie(request.getParameter("email"), cookie.getName());
            request.getRequestDispatcher("WEB-INF/html/done_page.html").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/html/registration.html").forward(request, response);
        }
    }
}
