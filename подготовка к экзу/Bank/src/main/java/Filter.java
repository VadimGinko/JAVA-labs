import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "Filter", urlPatterns = "/balance")
public class Filter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Date date = new Date();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String numbstr = request.getParameter("numb");
        if(Integer.parseInt(numbstr) < 7777)
        {
            resp.sendRedirect("wqe");
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
