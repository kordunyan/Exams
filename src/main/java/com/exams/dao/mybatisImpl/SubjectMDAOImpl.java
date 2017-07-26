package com.exams.dao.mybatisImpl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import com.exams.entity.mapper.SubjectMapper;
import com.exams.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class SubjectMDAOImpl implements SubjectDAO {
    @Override
    public void addSubject(Subject subject) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.insert(subject);
        session.commit();
        session.close();
    }

    @Override
    public Subject getByTitle(String title) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        Subject subject = mapper.getByTitle(title);
        session.close();
        return subject;
    }

    @Override
    public void delete(Subject subject) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.delete(subject);
        session.commit();
        session.close();
    }

    @Override
    public void update(Subject subject) {
        SqlSession session = MyBatisUtil.getSqlSessnioFactory().openSession();
        SubjectMapper mapper = session.getMapper(SubjectMapper.class);
        mapper.update(subject);
        session.commit();
        session.close();
    }
}
