package com.exams.service.impl;

import com.exams.dao.ExamDAO;
import com.exams.dao.impl.ExamDAOImpl;
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
		this.dao = new ExamDAOImpl();
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
	public List<Exam> getBySubjectId(Integer subjectId) {
		return dao.getBySubjectId(subjectId);
	}

	@Override
	public List<Exam> getByCreateDate(LocalDate createDate) {
		return dao.getByCreateDate(createDate);
	}

	@Override
	public Double getAvgBySubjectId(Integer subjectId) {
		return dao.getAvgBySubjectId(subjectId);
	}
}