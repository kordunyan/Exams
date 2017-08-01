package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.SubjectService;
import com.exams.service.impl.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
		String title = request.getParameter("title");
		try {
			subjectService.addSubject(new Subject(title));
		} catch (IncorectSubjectTitleException ex) {
			request.setAttribute("titleError", ex);
			request.setAttribute("page", "add/subject");
			request.getRequestDispatcher("/WEB-INF/addSubject.jsp").forward(request, response);
		}
		response.sendRedirect(request.getContextPath());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "add/subject");
		request.getRequestDispatcher("/WEB-INF/addSubject.jsp").forward(request, response);
	}
}
