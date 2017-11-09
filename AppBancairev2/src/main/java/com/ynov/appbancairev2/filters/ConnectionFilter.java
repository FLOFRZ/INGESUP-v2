package com.ynov.appbancairev2.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ynov.appbancairev2.servlet.ServletHelper;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter("/*")
public class ConnectionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ConnectionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
			  HttpServletRequest req = (HttpServletRequest) request;
			  HttpServletResponse res = (HttpServletResponse) response;
			  HttpSession session = req.getSession(false);
			  String loginURI = ServletHelper.getServletUrl(ServletHelper.SERVLET_LOGIN, req);
			 
			  boolean loggedIn = session != null && session.getAttribute("client") != null;
			  boolean loginRequest = req.getRequestURI().equals(loginURI);
			 
			        if (loggedIn || loginRequest) {
			            chain.doFilter(request, response);
			        } else {
			            res.sendRedirect(loginURI);
			        }
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
