package com.exams.service.impl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.impl.SubjectDAOImpl;
import com.exams.entity.Subject;
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
		this.dao = new SubjectDAOImpl();
		this.validator = new SubjectValidator();
	}

	@Override
	public void addSubject(Subject subject) throws Exception{
		if(!validator.vlidate(subject)){
			throw new Exception("Incorect subject");
		}
		dao.addSubject(subject);
	}

	@Override
	public Subject getByTitle(String title) {
		return dao.getByTitle(title);
	}
}
