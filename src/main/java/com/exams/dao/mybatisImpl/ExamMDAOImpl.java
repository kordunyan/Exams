package com.exams.dao.mybatisImpl;

import com.exams.dao.ExamDAO;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.entity.mapper.ExamMapper;
import com.exams.entity.mapper.SubjectMapper;
import com.exams.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;

public class ExamMDAOImpl implements ExamDAO{

    @Override
    public void addExam(Exam exam) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.addExam(exam);
        session.commit();
        session.close();
    }

    @Override
    public Exam getExamById(Integer id) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Exam exam = mapper.getById(id);
        session.close();
        return exam;
    }

    @Override
    public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        List<Exam> result = mapper.getBySubjectId(subjectId, orderType);
        session.close();
        return result;
    }

    @Override
    public List<Exam> getByCreateDate(LocalDate createDate) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        List<Exam> result = mapper.getByDate(createDate);
        session.close();
        return result;
    }

    @Override
    public Double getAvgBySubjectId(Integer subjectId) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Double result = mapper.getAvgBySubject(subjectId);
        session.close();
        return result;
    }

    @Override
    public void delete(Exam exam) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.delete(exam);
        session.commit();
        session.close();
    }

    @Override
    public void update(Exam exam) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.update(exam);
        session.commit();
        session.close();
    }

    @Override
    public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Exam exam = mapper.getBySubjectAndDate(subject, date);
        session.close();
        return exam;
    }

    @Override
    public Long getCount() {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Long count = mapper.getCount();
        session.close();
        return count;
    }

    @Override
    public void deleteAll() {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }

}
