package com.exams.service.impl;

import com.exams.dao.ExamDAO;
import com.exams.dao.hibernateImpl.ExamHDAOImpl;
import com.exams.dao.mybatisImpl.ExamMDAOImpl;
import com.exams.entity.Exam;
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

	public ExamServiceImpl(){
		this.dao = new ExamHDAOImpl();
		//this.dao = new ExamMDAOImpl();
		this.validator = new LocalDateValidator();
	}

	@Override
	public void addExam(Exam exam) throws Exception{
		if(!validator.vlidate(exam.getCreateDate())){
			throw new Exception("Incorect date");
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
	public void update(Exam exam) throws Exception {
		if(!validator.vlidate(exam.getCreateDate())){
			throw new Exception("Incorect date");
		}
		dao.update(exam);
	}
}
