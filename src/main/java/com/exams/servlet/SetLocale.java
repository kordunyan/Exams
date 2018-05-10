package com.exams.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/setlocale")
public class SetLocale extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locale = req.getParameter("locale");
		if (locale != null) {
			Cookie cookie = new Cookie("locale", locale);
			resp.addCookie(cookie);
		}
		resp.sendRedirect(req.getHeader("Referer"));
	}
}
