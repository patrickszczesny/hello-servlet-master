package pro.buildmysoftware.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecretFilter implements Filter {

    private static final String SECRET = "secret1234";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession();

        String passParam = httpRequest.getParameter("secret");
        session.setAttribute("secret" , passParam);

        if(SECRET.equals(session.getAttribute("secret"))
                || Integer.valueOf(1).equals(session.getAttribute("ifGooodSecret"))){
            // TODO: implement
            session.setAttribute("ifGooodSecret", 1);
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

        }


    }

    @Override
    public void destroy() {

    }
}