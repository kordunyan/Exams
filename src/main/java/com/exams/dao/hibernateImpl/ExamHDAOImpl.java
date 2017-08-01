package com.exams.dao.hibernateImpl;

import com.exams.dao.ExamDAO;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;


public class ExamHDAOImpl implements ExamDAO {

	private SessionFactory sessionFactory;

	public ExamHDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addExam(Exam exam) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(exam);
			tx.commit();
		}
	}

	@Override
	public Exam getExamById(Integer id) {
		try (Session session = sessionFactory.openSession()) {
			return session.byId(Exam.class).load(id);
		}
	}

	@Override
	public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
		try (Session session = sessionFactory.openSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.subject.id = :p_subject_id ORDER BY e.createDate "+ ((orderType)? "ASC":"DESC"));
			query.setParameter("p_subject_id", subjectId);
			return query.list();
		}
	}

	@Override
	public List<Exam> getByCreateDate(LocalDate createDate) {
		try (Session session = sessionFactory.openSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.createDate = :p_create_date ORDER BY e.subject.title ASC");
			query.setParameter("p_create_date", createDate);
			return query.list();
		}
	}

	@Override
	public Double getAvgBySubjectId(Integer subjectId) {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("SELECT ROUND(AVG(e.mark), 2) FROM Exam e WHERE e.subject.id = :p_subject_id");
			query.setParameter("p_subject_id", subjectId);
			return (Double) query.uniqueResult();
		}
	}

	@Override
	public void delete(Exam exam) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.delete(exam);
			tx.commit();
			session.close();
		}
	}

	@Override
	public void update(Exam exam) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			session.update(exam);
			tx.commit();
		}
	}

	@Override
	public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
		try (Session session = sessionFactory.openSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.subject.id = :p_subject_id AND createDate = :p_createCate");
			query.setParameter("p_subject_id", subject.getId());
			query.setParameter("p_createCate", date);
			return query.uniqueResult();
		}
	}

	@Override
	public Long getCount() {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("SELECT COUNT(*) FROM Exam");
			return (Long) query.uniqueResult();
		}
	}

	@Override
	public Long getCountBySubject(int subjectId) {
		try (Session session = sessionFactory.openSession()) {
			Query query = session.createQuery("SELECT COUNT(*) FROM Exam WHERE subject.id = :p_subject_id");
			query.setParameter("p_subject_id", subjectId);
			return (Long) query.uniqueResult();
		}
	}

	@Override
	public void deleteAll() {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete FROM Exam");
			query.executeUpdate();
			tx.commit();
		}
	}
}
