package com.exams.dao.hibernateImpl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectHDAOImpl implements SubjectDAO {

    private SessionFactory sessionFactory;

    public SubjectHDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSubject(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(subject);
            tx.commit();
        }
    }

    @Override
    public Subject getByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            Query<Subject> query = session.createQuery("FROM Subject s WHERE s.title = :p_title");
            query.setParameter("p_title", title);
            return query.uniqueResult();
        }
    }

    @Override
    public Subject getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.byId(Subject.class).load(id);
        }
    }

    @Override
    public void setEnabled(int subjectId, boolean isEnable) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query<Subject> query = session.createQuery("UPDATE Subject SET isenabled = :p_isenabled WHERE id = :p_id");
            query.setParameter("p_id", subjectId);
            query.setParameter("p_isenabled", isEnable);
            query.executeUpdate();
            tx.commit();
        }
    }

    @Override
    public List<Subject> getForPage(Integer page, Integer perPage) {
        try (Session session = sessionFactory.openSession()) {
            Query<Subject> query = session.createQuery("FROM Subject s ORDER BY s.title");
            query.setFirstResult((page-1)*perPage);
            query.setMaxResults(perPage);
            return query.list();
        }
    }

    @Override
    public void insertAll(List<Subject> subjects) {
        try (StatelessSession session = sessionFactory.openStatelessSession()) {
            Transaction tx = session.beginTransaction();
            for(Subject subject : subjects){
                session.insert(subject);
            }
            tx.commit();
        }
    }

    @Override
    public void delete(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(subject);
            tx.commit();
        }
    }

    @Override
    public void update(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(subject);
            tx.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete FROM Subject");
            query.executeUpdate();
            tx.commit();
        }
    }

    @Override
    public Long getCount() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("SELECT COUNT(*) FROM Subject");
            return (Long) query.uniqueResult();
        }
    }

    @Override
    public List<Subject> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Subject> query = session.createQuery("FROM Subject s ORDER BY s.title");
            return query.list();
        }
    }

    @Override
    public List<Subject> getAllWithExam() {
        return this.getAll();
    }
}
