package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.i18n.ResourceBundleFactory;
import com.exams.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/add/subject")
public class AddSubject extends HttpServlet {

	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		this.subjectService = ServiceFactory.getSubjectService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> messages = new HashMap<>();
		String title = request.getParameter("title");
		try {
			subjectService.addSubject(new Subject(title));
		} catch (IncorectSubjectTitleException ex) {
			messages.put("title", ResourceBundleFactory.getResourceBundle().getString("messages.error.subject"));
		}

		if (messages.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.setAttribute("messages", messages);
			request.setAttribute("page", "add/subject");
			request.getRequestDispatcher("/WEB-INF/addSubject.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "add/subject");
		request.getRequestDispatcher("/WEB-INF/addSubject.jsp").forward(request, response);
	}
}
