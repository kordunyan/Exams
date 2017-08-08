package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dtabase/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	private Gson gson;
	private ExamService examService;
	private SubjectService subjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
		this.examService = ServiceFactory.getExamService();
		this.subjectService = ServiceFactory.getSubjectService();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("dump");
		BufferedReader br = new BufferedReader(new InputStreamReader(filePart.getInputStream(), "UTF-8"));
		List<Subject> subjects = new ArrayList<>();
		Type type = new TypeToken<List<Subject>>() {
		}.getType();
		subjects = gson.fromJson(br, type);
		examService.deleteAll();
		subjectService.deleteAll();
		subjectService.insertAll(subjects);
		for (Subject subject : subjects) {
			if (subject.getExams().size() != 0) {
				Subject saved = subjectService.getByTitle(subject.getTitle());
				examService.addAll(subject.getExams(), saved);
			}
		}
		if (request.getContextPath().equals("")) response.sendRedirect("/");
		else response.sendRedirect(request.getContextPath());
	}
}
