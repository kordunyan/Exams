package com.exams.servlet;


import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/database/dump")
public class MakeDump extends HttpServlet{

    private ExamService examService;
    private SubjectService subjectService;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
        this.examService = ServiceFactory.getExamService();
        this.subjectService = ServiceFactory.getSubjectService();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = subjectService.getAll();
        for(Subject subject :  subjects){
            subject.setExams(examService.getBySubjectId(subject.getId(), true));
        }
        response.setContentType("application/json");
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"dump.json\"");
        PrintWriter writer = response.getWriter();
        writer.println(gson.toJson(subjects));
        writer.close();
    }
}
