package com.exams.servlet;

import com.exams.entity.Subject;
import com.exams.service.SubjectService;
import com.exams.service.impl.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class IndexServlet extends HttpServlet {

	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.subjectService = new SubjectServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjects = subjectService.getAll();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", "home");
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
