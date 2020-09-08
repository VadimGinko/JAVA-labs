import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import org.apache.log4j.Logger;

@WebFilter(filterName = "Filter2", urlPatterns = "welcome.jsp")
public class Filter2 implements Filter {
    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Date date = new Date();
        HttpServletRequest request = (HttpServletRequest) req;
        LOGGER.info(date.toString() + request.getRequestURI());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
