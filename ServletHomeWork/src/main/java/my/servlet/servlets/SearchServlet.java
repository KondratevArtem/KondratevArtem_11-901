package my.servlet.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/user_search")
public class SearchServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "QAZwsx123456@";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/servlet";
    private UsersRepository usersRepository;
    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
        try {
            objectMapper = new ObjectMapper();
            Class.forName("org.postgresql.Driver");
            usersRepository = new UsersRepositoryJdbcImpl(
                    DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = objectMapper.readValue(request.getReader(), User.class);
        String users = objectMapper.writeValueAsString(usersRepository.findAllByNameStartingWith(user.getFirstName()));
        System.out.println(users);
        response.setContentType("application/json");
        response.getWriter().println(users);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/html/live_search.html").forward(request, response);
    }
}