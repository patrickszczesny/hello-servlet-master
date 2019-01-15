package pro.buildmysoftware.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        // powinno robic to samo co ten kod na dole
/*        Object loggedAttr = httpRequest.getSession().getAttribute("logged");
        if (Boolean.TRUE.equals(loggedAttr)) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;
            httpResponse.sendRedirect("../login.jsp");
        }*/

        // @formatter:off
        Boolean logged = Optional.ofNullable(httpRequest.getSession().getAttribute("logged"))
                .map(Boolean.class::cast).orElse(false);
        // @formatter:on
        if (logged) {
            chain.doFilter(req, resp);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;
            httpResponse.sendRedirect("../login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
