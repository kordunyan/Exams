package com.exams.dao.mybatisImpl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import com.exams.entity.mapper.SubjectMapper;
import com.exams.exception.SubjectTitleExists;
import com.exams.util.MyBatisUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SubjectMDAOImpl implements SubjectDAO {

    private SqlSessionFactory sqlSessionFactory;

    public SubjectMDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void addSubject(Subject subject){
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.insert(subject);
        session.commit();
        session.close();
    }

    @Override
    public Subject getByTitle(String title) {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        Subject subject = mapper.getByTitle(title);
        session.close();
        return subject;
    }

    @Override
    public Subject getById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        Subject subject = mapper.getById(id);
        session.close();
        return subject;
    }

    @Override
    public void delete(Subject subject) {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.delete(subject);
        session.commit();
        session.close();
    }

    @Override
    public void update(Subject subject) {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.update(subject);
        session.commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }

    @Override
    public Long getCount() {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        Long count =  mapper.getCount();
        session.close();
        return count;
    }

    @Override
    public List<Subject> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        List<Subject> subjects =  mapper.findAllSubject();
        session.close();
        return subjects;
    }
}
