package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.PaginationService;
import com.exams.service.SubjectService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.PaginationServiceImpl;
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
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		this.examService = ServiceFactory.getExamService();
		this.subjectService = ServiceFactory.getSubjectService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page;
		try{
			page = Integer.parseInt(request.getParameter("page"));
		}
		catch (Exception ex){
			page = 1;
		}

		try{
			int subjectId = Integer.parseInt(request.getParameter("subject"));
			boolean order = Boolean.parseBoolean(request.getParameter("order"));
			List<Exam> exams = examService.getExamsForPage(page, ExamServiceImpl.PER_PAGE, subjectId, order);
			Subject subject = subjectService.getById(subjectId);

			long countItems = examService.getCountBySubject(subjectId);
			int pages = examService.calculateCountPages(countItems, ExamServiceImpl.PER_PAGE);
			PaginationService pagination = new PaginationServiceImpl(5, pages, page);
			request.setAttribute("currentPage", page);
			request.setAttribute("startPage", pagination.getStart());
			request.setAttribute("endPage", pagination.getEnd());
			request.setAttribute("pages", pages);

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
