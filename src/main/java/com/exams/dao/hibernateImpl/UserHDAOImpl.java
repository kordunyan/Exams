package com.exams.dao.hibernateImpl;

import com.exams.dao.UserDAO;
import com.exams.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserHDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    public UserHDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.byId(User.class).load(id);
        }
    }

    @Override
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }
    }

    @Override
    public User getByLoginPassword(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User u WHERE u.login = :p_login AND u.password = :p_password");
            query.setParameter("p_login", user.getLogin());
            query.setParameter("p_password", user.getPassword());
            return query.uniqueResult();
        }
    }
}
