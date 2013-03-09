package filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Author: sahmed
 * Date: 3/6/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */

@WebFilter(filterName = "LoginFilter", servletNames = "Faces Servlet", urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String requestedUri;

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;
        session = request.getSession(false);
        requestedUri = request.getRequestURI().toString();

        System.out.println("doFilter: " + requestedUri);

        if (requestedUri.equals("/evento/home")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else if (requestedUri.equals("/evento/event/create")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else if (requestedUri.equals("/evento/event/join/suc")) {
            redirect(servletRequest, servletResponse, filterChain);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void redirect(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if ((session == null || session.getAttribute("userId") == null)) {
            response.sendRedirect("/evento/index");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
