package pro.buildmysoftware.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/secret")
public class SecretServlet extends HttpServlet {
    private static final String SECRET = "secret1234";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            HttpSession session = req.getSession();

        if (SECRET.equals(req.getParameter("secret"))||Integer.valueOf(1).equals(session.getAttribute("secret"))) {
            req.getRequestDispatcher("goodSecret.jsp").forward(req, resp);
            session.setAttribute("secret",1);
        } else {
            req.getRequestDispatcher("badSecret.jsp").forward(req, resp);
        }
    }
}
