package com.exams.servlet;

import com.exams.entity.Exam;
import com.exams.service.ExamService;
import com.exams.service.impl.ExamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/bydate")
public class GetByDate extends HttpServlet {

	private ExamService examService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.examService = new ExamServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDate date = null;
		try{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			date = LocalDate.parse(request.getParameter("date"), dtf);
			List<Exam> exms = examService.getByCreateDate(date);
			request.setAttribute("exams", exms);
		}
		catch (Exception ex){}
		request.setAttribute("page", "bydate");
		request.setAttribute("date", date);
		request.getRequestDispatcher("WEB-INF/gradesByDate.jsp").forward(request, response);
	}
}
