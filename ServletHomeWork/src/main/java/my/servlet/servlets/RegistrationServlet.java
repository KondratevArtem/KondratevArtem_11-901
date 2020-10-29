package my.servlet.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/html/registration.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        myDB.addUser(request.getParameter("exampleInputFirstName"),
//                request.getParameter("exampleInputLastName"),
//                Integer.valueOf(request.getParameter("exampleInputAge")),
//                request.getParameter("exampleInputEmail1"),
//                request.getParameter("exampleInputPassword1"));
//        request.getRequestDispatcher("WEB-INF/html/done_page.html").forward(request, response);
    }
}
