package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.service.PaginationService;
import com.exams.service.SubjectService;
import com.exams.service.impl.PaginationServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("")
public class IndexServlet extends HttpServlet {

	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
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
		List<Subject> subjects = subjectService.getFormPage(page, SubjectServiceImpl.PER_PAGE);
		long countItems = subjectService.getcount();
		int pages = subjectService.calculateCountPages(countItems, SubjectServiceImpl.PER_PAGE);
		PaginationService pagination = new PaginationServiceImpl(5, pages, page, "/?page=");

		Locale locale = new Locale("ua");
		ResourceBundle messages = ResourceBundle.getBundle("locale/messages", locale);

		request.setAttribute("msg", messages);
		request.setAttribute("pagination", pagination);
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", "home");
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
