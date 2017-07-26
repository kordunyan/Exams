package com.exams.dao.impl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import com.exams.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectDAOImpl implements SubjectDAO{

	@Override
	public void addSubject(Subject subject) {
		try(Session session = SessionUtil.getSession()){
			Transaction tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public Subject getByTitle(String title) {
		Subject subject = null;
		try(Session session = SessionUtil.getSession()){
			Query<Subject> query = session.createQuery("FROM Subject s WHERE s.title = :p_title");
			query.setParameter("p_title", title);
			subject = query.uniqueResult();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return subject;
	}
}