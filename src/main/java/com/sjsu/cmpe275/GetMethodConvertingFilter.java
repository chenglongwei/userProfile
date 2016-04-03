package com.sjsu.cmpe275;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @author chenglongwei
 * @version 1.0
 * @see <a href="http://stackoverflow.com/questions/24673041/405-jsp-error-with-put-method?lq=1">
 * 405-jsp-with-Delete/put</a>
 * <p>
 * When return a view name from your controller method, the Spring DispatcherServlet
 * will do a forward to the given view, preserving the original DELETE/PUT method.
 * On attempting to handle this forward, Tomcat will refuse it, with the justification
 * that a DELETE/PUT to a JSP could be construed to mean "replace this JSP file on the
 * server with the content of this request." Really you want your controller to handle
 * your DELETE/PUT requests and then to subsequently forward to your JSPs as GET.
 * Fortunately Servlet 3.0 provides a means to filter purely on the FORWARD dispatcher.
 * @since 2016-04-03
 */
public class GetMethodConvertingFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(wrapRequest((HttpServletRequest) request), response);
    }

    @Override
    public void destroy() {
        // do nothing
    }

    private static HttpServletRequestWrapper wrapRequest(HttpServletRequest request) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
    }
}
