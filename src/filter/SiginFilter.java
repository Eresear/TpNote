package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SiginFilter")
public class SiginFilter implements Filter {
    private ServletContext ctx;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpServletResponse httpResponse = (HttpServletResponse)resp;
        HttpSession session = httpRequest.getSession();
        String auth = (String)session.getAttribute("authenticated");
        if ("yes".equals(auth))
            chain.doFilter(req, resp);
        else
            httpResponse.sendRedirect(ctx.getContextPath() + "/login.jsp");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
