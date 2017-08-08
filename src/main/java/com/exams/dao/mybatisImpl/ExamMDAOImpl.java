package com.exams.dao.mybatisImpl;

import com.exams.dao.ExamDAO;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.entity.mapper.ExamMapper;
import com.exams.entity.mapper.SubjectMapper;
import com.exams.util.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.LocalDate;
import java.util.List;

public class ExamMDAOImpl implements ExamDAO{

    private SqlSessionFactory sqlSessionFactory;

    public ExamMDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void addExam(Exam exam) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.addExam(exam);
        session.commit();
        session.close();
    }

    @Override
    public Exam getExamById(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Exam exam = mapper.getById(id);
        session.close();
        return exam;
    }

    @Override
    public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        List<Exam> result = mapper.getBySubjectId(subjectId, orderType);
        session.close();
        return result;
    }

    @Override
    public List<Exam> getBySubjectIdForPage(Integer page, Integer perPage, Integer subjectId, boolean orderType) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        List<Exam> result = mapper.getBySubjectIdForPage(subjectId, orderType, new RowBounds((page-1)*perPage, perPage));
        session.close();
        return result;
    }

    @Override
    public List<Exam> getByCreateDate(LocalDate createDate) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        List<Exam> result = mapper.getByDate(createDate);
        session.close();
        return result;
    }

    @Override
    public Double getAvgBySubjectId(Integer subjectId) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Double result = mapper.getAvgBySubject(subjectId);
        session.close();
        return result;
    }

    @Override
    public void delete(Exam exam) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.delete(exam);
        session.commit();
        session.close();
    }

    @Override
    public void update(Exam exam) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.update(exam);
        session.commit();
        session.close();
    }

    @Override
    public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Exam exam = mapper.getBySubjectAndDate(subject, date);
        session.close();
        return exam;
    }

    @Override
    public Long getCount() {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Long count = mapper.getCount();
        session.close();
        return count;
    }

    @Override
    public Long getCountBySubject(int subjectId) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        Long count = mapper.getCountBySubjectId(subjectId);
        session.close();
        return count;
    }

    @Override
    public void insertAll(List<Exam> exams, Subject subject) {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.insertAll(exams, subject.getId());
        session.commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SqlSession session = sqlSessionFactory.openSession();
        ExamMapper mapper = session.getMapper(ExamMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }

}
