package com.exams.dao.mybatisImpl;

import com.exams.dao.UserDAO;
import com.exams.entity.User;
import com.exams.entity.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserMDAOImpl implements UserDAO {

    private SqlSessionFactory sqlSessionFactory;

    public UserMDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User getById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getById(id);
        session.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(user);
        session.commit();
        session.close();
    }

    @Override
    public User getByLoginPassword(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User result = mapper.getByLoginAndPassword(user);
        session.close();
        return result;
    }
}
