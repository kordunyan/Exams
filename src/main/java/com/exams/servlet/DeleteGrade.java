package com.exams.servlet;


import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.service.ExamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mark/delete")
public class DeleteGrade extends HttpServlet {

	private ExamService examService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		this.examService = ServiceFactory.getExamService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			int markId = Integer.parseInt(request.getParameter("mark"));
			Exam exam = new Exam();
			exam.setId(markId);
			examService.delete(exam);
			response.sendRedirect(String.format("%s/grades?subject=%d", request.getContextPath(), subjectId));
			return;
		}
		catch(Exception ex){}
		if(request.getContextPath().equals("")) response.sendRedirect("/");
		else response.sendRedirect(request.getContextPath());
	}
}
