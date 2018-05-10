package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Subject;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/subject/delete")
public class DeleteSubject extends HttpServlet {

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
        log("Start delete subject");
        try{
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            Long count = examService.getCountBySubject(subjectId);
            if(count > 0){
                subjectService.setEnabled(subjectId, false);
            }
            else{
                Subject subject = new Subject();
                subject.setId(subjectId);
                subjectService.delete(subject);
            }
        }
        catch (Exception ex){
            //log.error("Error to delete or disable subject", ex);
        }
        if(request.getContextPath().equals("")) response.sendRedirect("/");
        else response.sendRedirect(request.getContextPath());
    }
}
