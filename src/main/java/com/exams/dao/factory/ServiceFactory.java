package com.exams.dao.factory;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.ExamHDAOImpl;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.hibernateImpl.UserHDAOImpl;
import com.exams.dao.mybatisImpl.ExamMDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.dao.mybatisImpl.UserMDAOImpl;
import com.exams.service.ExamService;
import com.exams.service.SubjectService;
import com.exams.service.UserService;
import com.exams.service.impl.ExamServiceImpl;
import com.exams.service.impl.SubjectServiceImpl;
import com.exams.service.impl.UserServiceImpl;
import com.exams.util.HibernateUtil;
import com.exams.util.MyBatisUtil;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;

@Log4j(topic = "file")
public class ServiceFactory {

    private static SubjectService subjectService;
    private static ExamService examService;
    private static UserService userService;

    private static DatabaseType currentType;
    private static ORMType currentORMType;

    static {
        currentORMType = ORMType.MYBATIS;
    }

    public static void setDataBaseConfig(DatabaseType dataBaseType){
        if(currentType != dataBaseType){
            log.info("Change database config to : " + dataBaseType);
            currentType = dataBaseType;
            if(currentORMType == ORMType.MYBATIS){
                SqlSessionFactory sqlSessionFactory = new MyBatisUtil(dataBaseType).getSqlSessnioFactory();
                subjectService = new SubjectServiceImpl(new SubjectMDAOImpl(sqlSessionFactory));
                examService = new ExamServiceImpl(new ExamMDAOImpl(sqlSessionFactory));
                userService = new UserServiceImpl(new UserMDAOImpl(sqlSessionFactory));
            }
            else if(currentORMType == ORMType.HIBERNATE){
                SessionFactory sessionFactory = new HibernateUtil(dataBaseType).getSessionFactory();
                subjectService = new SubjectServiceImpl(new SubjectHDAOImpl(sessionFactory));
                examService = new ExamServiceImpl(new ExamHDAOImpl(sessionFactory));
                userService = new UserServiceImpl(new UserHDAOImpl(sessionFactory));
            }
        }
    }

    public static ExamService getExamService(){
        return examService;
    }

    public static SubjectService getSubjectService(){
        return subjectService;
    }

    public static UserService getUserService(){
        return userService;
    }
}
