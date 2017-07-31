package com.exams.servlet;

import com.exams.dao.factory.ServiceFactory;
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

@WebServlet("/avg")
public class AVGBySubject extends HttpServlet {

	private ExamService examService;
	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.examService = ServiceFactory.getExamService();
		this.subjectService = ServiceFactory.getSubjectService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			Subject subject = subjectService.getById(subjectId);
			if(subject != null){
				request.setAttribute("avg", examService.getAvgBySubjectId(subjectId));
				request.setAttribute("curSubject", subject);
			}
		}
		catch(Exception ex){}
		List<Subject> subjects = subjectService.getAll();
		request.setAttribute("subjects", subjects);
		request.getRequestDispatcher("WEB-INF/subjectAVG.jsp").forward(request, response);
	}
}
