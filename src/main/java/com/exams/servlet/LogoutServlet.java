package com.exams.servlet;

import com.exams.entity.User;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j(topic = "admin")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        log.info("User '" + user.getLogin() + "', is loged out");
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath() + "/");
    }
}
