package com.exams.dao.hibernateImpl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import com.exams.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectHDAOImpl implements SubjectDAO {


    @Override
    public void addSubject(Subject subject) {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(subject);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Subject getByTitle(String title) {
        Subject subject = null;
        try (Session session = SessionUtil.getSession()) {
            Query<Subject> query = session.createQuery("FROM Subject s WHERE s.title = :p_title");
            query.setParameter("p_title", title);
            subject = query.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subject;
    }

    @Override
    public Subject getById(int id) {
        Subject subject = null;
        try (Session session = SessionUtil.getSession()) {
            subject = session.byId(Subject.class).load(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subject;
    }

    @Override
    public void delete(Subject subject) {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(subject);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Subject subject) {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(subject);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete FROM Subject");
            query.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Long getCount() {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("SELECT COUNT(*) FROM Subject");
            return (Long) query.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1l;
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> result = null;
        try (Session session = SessionUtil.getSession()) {
            Query<Subject> query = session.createQuery("FROM Subject s ORDER BY s.title");
            result = query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
