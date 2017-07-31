package com.exams.dao.factory;

import com.exams.dao.SubjectDAO;
import com.exams.dao.mybatisImpl.ExamMDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;
import com.exams.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSessionFactory;

public class ServiceFactory {

    private static SubjectService subjectService;
    private static ExamService examService;

    static {
        setDataBaseConfig("prod");
    }

    public static void setDataBaseConfig(String type){
        SqlSessionFactory sqlSessionFactory = new MyBatisUtil(type).getSqlSessnioFactory();
        subjectService = new SubjectServiceImpl(new SubjectMDAOImpl(sqlSessionFactory));
        examService = new ExamServiceImpl(new ExamMDAOImpl(sqlSessionFactory));
    }

    public static ExamService getExamService(){
        return examService;
    }

    public static SubjectService getSubjectService(){
        return subjectService;
    }
}
