package com.exams.service.impl;

import com.exams.dao.ExamDAO;
import com.exams.dao.hibernateImpl.ExamHDAOImpl;
import com.exams.dao.mybatisImpl.ExamMDAOImpl;
import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.ExamExistsException;
import com.exams.exception.IncorectDateException;
import com.exams.service.ExamService;
import com.exams.validator.Validator;
import com.exams.validator.impl.LocalDateValidator;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public class ExamServiceImpl implements ExamService {

	private ExamDAO dao;
	private Validator validator;

	public ExamServiceImpl(ExamDAO dao){
		//this.dao = new ExamHDAOImpl();
		//this.dao = new ExamMDAOImpl();
		this.dao = dao;
		this.validator = new LocalDateValidator();
	}

	@Override
	public void addExam(Exam exam) throws IncorectDateException, ExamExistsException{
		if(!validator.vlidate(exam.getCreateDate())){
			throw new IncorectDateException("Incorect date");
		}
		if(dao.getBySubjectAndDate(exam.getSubject(), exam.getCreateDate()) != null){
			throw new ExamExistsException("Such exam exists on this date");
		}
		dao.addExam(exam);
	}

	@Override
	public Exam getById(Integer id) {
		return dao.getExamById(id);
	}

	@Override
	public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
		return dao.getBySubjectId(subjectId, orderType);
	}

	@Override
	public List<Exam> getByCreateDate(LocalDate createDate) {
		return dao.getByCreateDate(createDate);
	}

	@Override
	public Double getAvgBySubjectId(Integer subjectId) {
		return dao.getAvgBySubjectId(subjectId);
	}

	@Override
	public void delete(Exam exam) {
		dao.delete(exam);
	}

	@Override
	public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
		return dao.getBySubjectAndDate(subject, date);
	}

	@Override
	public Long getCount() {
		return dao.getCount();
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public void update(Exam exam) throws IncorectDateException, ExamExistsException {
		if(!validator.vlidate(exam.getCreateDate())){
			throw new IncorectDateException("Incorect date");
		}
		if(dao.getBySubjectAndDate(exam.getSubject(), exam.getCreateDate()) != null){
			throw new ExamExistsException("Such exam exists on this date");
		}
		dao.update(exam);
	}



}
