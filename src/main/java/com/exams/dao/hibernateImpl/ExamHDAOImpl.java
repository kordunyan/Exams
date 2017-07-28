package com.exams.dao.hibernateImpl;

import com.exams.dao.ExamDAO;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public class ExamHDAOImpl implements ExamDAO {
	@Override
	public void addExam(Exam exam) {
		try (Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			session.save(exam);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Exam getExamById(Integer id) {
		Exam exam = null;
		try (Session session = SessionUtil.getSession()) {
			exam = session.byId(Exam.class).load(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return exam;
	}

	@Override
	public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
		List<Exam> exam = null;
		try (Session session = SessionUtil.getSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.subject.id = :p_subject_id ORDER BY e.createDate "+ ((orderType)? "ASC":"DESC"));
			query.setParameter("p_subject_id", subjectId);
			exam = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return exam;
	}

	@Override
	public List<Exam> getByCreateDate(LocalDate createDate) {
		List<Exam> exam = null;
		try (Session session = SessionUtil.getSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.createDate = :p_create_date ORDER BY e.subject.title ASC");
			query.setParameter("p_create_date", createDate);
			exam = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return exam;
	}

	@Override
	public Double getAvgBySubjectId(Integer subjectId) {
		try (Session session = SessionUtil.getSession()) {
			Query query = session.createQuery("SELECT ROUND(AVG(e.mark), 2) FROM Exam e WHERE e.subject.id = :p_subject_id");
			query.setParameter("p_subject_id", subjectId);
			return (Double) query.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0.0;
	}

	@Override
	public void delete(Exam exam) {
		try (Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			session.delete(exam);
			tx.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(Exam exam) {
		try (Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			session.update(exam);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
		Exam exam = null;
		try (Session session = SessionUtil.getSession()) {
			Query<Exam> query = session.createQuery("FROM Exam e WHERE e.subject.id = :p_subject_id AND createDate = :p_createCate");
			query.setParameter("p_subject_id", subject.getId());
			query.setParameter("p_createCate", date);
			return query.uniqueResult();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getCount() {
		try (Session session = SessionUtil.getSession()) {
			Query query = session.createQuery("SELECT COUNT(*) FROM Exam");
			return (Long) query.uniqueResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1l;
	}

	@Override
	public void deleteAll() {
		try (Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete FROM Exam");
			query.executeUpdate();
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
