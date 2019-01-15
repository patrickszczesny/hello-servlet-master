package pro.buildmysoftware.Servlet;

import pro.buildmysoftware.data.Accounts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/signIn")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String> users = Accounts.getUsers();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean credentialsOk = users.entrySet().stream().
                anyMatch(e -> e.getKey().equals(login)
                        && e.getValue().equals(password));
        req.getSession().setAttribute("logged", credentialsOk);

        resp.sendRedirect("app/index.jsp");
    }
}
