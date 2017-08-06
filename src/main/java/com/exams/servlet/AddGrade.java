package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.ExamExistsException;
import com.exams.exception.IncorectDateException;
import com.exams.exception.IncorectMarkException;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@Log4j(topic = "file")
@WebServlet("/add/grade")
public class AddGrade extends HttpServlet {

	private ExamService examService;
	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		this.examService = ServiceFactory.getExamService();
		this.subjectService = ServiceFactory.getSubjectService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<>();
		Subject subject = null;
		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			subject = subjectService.getById(subjectId);
		}
		catch (NumberFormatException ex){}

		try {
			if (subject == null) {
				messages.put("global", "Such subject not exists");
			} else if (!subject.getIsEnabled()) {
				messages.put("global", "Subject is disabled");
			} else {
				request.setAttribute("subject", subject);
				int mark = Math.abs(Integer.parseInt(request.getParameter("mark")));
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(request.getParameter("createdate"), dtf);
				examService.addExam(new Exam(mark, date, subject));
			}
		} catch (ExamExistsException ex) {
			messages.put("global", ex.getMessage());
		} catch (IncorectDateException ex) {
			messages.put("createDate", ex.getMessage());
		} catch (NumberFormatException ex) {
			messages.put("mark", "Mark should be a numeric");
		} catch (IncorectMarkException ex) {
			messages.put("mark", ex.getMessage());
		} catch (DateTimeParseException ex){
			messages.put("createDate", "Incorect date format");
		}
		catch (Exception ex) {
			log.error("Error to add mark", ex);
		}

		System.out.println(messages);

		if(messages.isEmpty()){
			response.sendRedirect(String.format("%s/grades?subject=%d", request.getContextPath(), subject.getId()));
		}
		else{
			request.setAttribute("subject", subject);
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("/WEB-INF/addGrade.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			Subject subject = subjectService.getById(subjectId);
			request.setAttribute("subject", subject);
		} catch (Exception ex) {
		}
		request.getRequestDispatcher("/WEB-INF/addGrade.jsp").forward(request, response);
	}
}