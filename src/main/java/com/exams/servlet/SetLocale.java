package com.exams.servlet;

import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Log4j(topic = "file")
@WebServlet("/setlocale")
public class SetLocale extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("locale");
        if(locale != null){
            Cookie cookie = new Cookie("locale", locale);
            resp.addCookie(cookie);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
