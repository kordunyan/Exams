package com.exams.servlet;

import com.exams.dao.factory.DatabaseType;
import com.exams.dao.factory.ServiceFactory;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.ExamExistsException;
import com.exams.exception.IncorectDateException;
import com.exams.exception.IncorectSubjectTitleException;
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
        for(Subject subject : subjects){
            try {
                subjectService.addSubject(subject);
                Subject saved = subjectService.getByTitle(subject.getTitle());
                for(Exam exam : subject.getExams()){
                    exam.setSubject(saved);
                    examService.addExam(exam);
                }
            } catch (IncorectSubjectTitleException e) {
                e.printStackTrace();
            }
            catch (IncorectDateException e) {
                e.printStackTrace();
            } catch (ExamExistsException e) {
                e.printStackTrace();
            }
        }
        if(request.getContextPath().equals("")) response.sendRedirect("/");
        else response.sendRedirect(request.getContextPath());
    }
}
