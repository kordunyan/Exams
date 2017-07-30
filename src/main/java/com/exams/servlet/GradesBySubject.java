package com.exams.servlet;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sanya on 30.07.2017.
 */
@WebServlet("/grades")
public class GradesBySubject extends HttpServlet {

	private ExamService examService;
	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.examService = new ExamServiceImpl();
		this.subjectService = new SubjectServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			boolean order = Boolean.parseBoolean(request.getParameter("order"));
			List<Exam> exams = examService.getBySubjectId(subjectId, order);
			Subject subject = subjectService.getById(subjectId);
			request.setAttribute("order", order);
			request.setAttribute("subject", subject);
			request.setAttribute("subjectId", subjectId);
			request.setAttribute("exams", exams);
		}
		catch (Exception ex){}
		request.setAttribute("page", "home");
		request.getRequestDispatcher("WEB-INF/allGrades.jsp").forward(request, response);
	}
}