package com.exams.service.impl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.SubjectService;
import com.exams.validator.Validator;
import com.exams.validator.impl.SubjectValidator;

/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO dao;
	private Validator validator;

	public SubjectServiceImpl(){
		//this.dao = new SubjectHDAOImpl();
		this.dao = new SubjectMDAOImpl();
		this.validator = new SubjectValidator();
	}

	@Override
	public void addSubject(Subject subject) throws Exception{
		if(!validator.vlidate(subject)){
			throw new IncorectSubjectTitleException("Incorect subject");
		}
		dao.addSubject(subject);
	}

	@Override
	public Subject getByTitle(String title) {
		return dao.getByTitle(title);
	}

	@Override
	public void delete(Subject subject) {
		dao.delete(subject);
	}

	@Override
	public void update(Subject subject) throws Exception{
		if(!validator.vlidate(subject)){
			throw new IncorectSubjectTitleException("Incorect subject");
		}
		dao.update(subject);
	}

	@Override
	public Long getcount() {
		return dao.getCount();
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}
}
