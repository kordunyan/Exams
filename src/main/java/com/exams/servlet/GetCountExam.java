package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.service.ExamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/subject/countexams")
public class GetCountExam extends HttpServlet {

    private ExamService examService;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        ServiceFactory.setDataBaseConfig(DatabaseType.PRODUCTION);
        this.examService = ServiceFactory.getExamService();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> result = new HashMap<>();
        try{
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            result.put("count", examService.getCountBySubject(subjectId));
            result.put("subject", subjectId);
            result.put("status", true);
        }
        catch (Exception ex){
            result.put("status", false);
        }
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.println(gson.toJson(result));
    }
}
