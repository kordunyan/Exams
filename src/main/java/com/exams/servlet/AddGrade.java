package com.exams.servlet;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.ExamExistsException;
import com.exams.exception.IncorectDateException;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/add/grade")
public class AddGrade extends HttpServlet {

	private ExamService examService;
	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.examService = new ExamServiceImpl();
		this.subjectService = new SubjectServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			Subject subject = subjectService.getById(subjectId);
			if(subject == null) request.getRequestDispatcher("/WEB-INF/addGrade.jsp").forward(request, response);
			request.setAttribute("subject", subject);
			int mark = Math.abs(Integer.parseInt(request.getParameter("mark")));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(request.getParameter("createdate"), dtf);
			examService.addExam(new Exam(mark, date, subject));
			response.sendRedirect(String.format("%s/grades?subject=%d", request.getContextPath(), subject.getId()));
			return;
		}
		catch(ExamExistsException ex){
			request.setAttribute("examError", ex);
		}
		catch (IncorectDateException ex){
			request.setAttribute("errorDate", ex);
		}
		catch (NumberFormatException ex){
			request.setAttribute("errorMark", new NumberFormatException("Mark should be a numeric"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/addGrade.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			Subject subject = subjectService.getById(subjectId);
			request.setAttribute("subject", subject);
		}
		catch(Exception ex){}
		request.getRequestDispatcher("/WEB-INF/addGrade.jsp").forward(request, response);
	}
}