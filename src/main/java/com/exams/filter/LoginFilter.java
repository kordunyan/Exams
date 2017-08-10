package com.exams.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sanya on 04.08.2017.
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String loginURI = request.getContextPath() + "/login";
		String pattern = String.format("^%s/(css|scripts|fonts|img){1}/(.)*", request.getContextPath());

		boolean loggedIn = session != null && session.getAttribute("user") != null;
		boolean loginRequest = request.getRequestURI().equals(loginURI);
		boolean isResources = request.getRequestURI().matches(pattern);

		if(isResources || loggedIn || loginRequest){
			filterChain.doFilter(request, response);
		}
		else{
			response.sendRedirect(loginURI);
		}
	}
}
