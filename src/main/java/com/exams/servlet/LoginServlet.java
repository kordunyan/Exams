package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.User;
import com.exams.service.UserService;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j(topic = "admin")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		userService = ServiceFactory.getUserService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Map<String, String> messages = new HashMap<>();
		if(login == null || login.isEmpty()){
			messages.put("username", "Please enter username");
		}
		if(password == null || password.isEmpty()){
			messages.put("password", "Please enter password");
		}

		if(messages.isEmpty()){
			User user = new User();
			user.setPassword(password);
			user.setLogin(login);
			User checked = userService.getByLoginAndPassword(user);
			if(checked != null){
				log.info("User '" + user.getLogin() + "', is logged in");
				HttpSession session = request.getSession();
				session.setAttribute("user", checked);
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}
			else{
				messages.put("login", "Incorect login or password");
			}
		}
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
}
