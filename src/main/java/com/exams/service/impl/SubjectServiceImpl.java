package com.exams.service.impl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.SubjectService;
import com.exams.validator.Validator;
import com.exams.validator.impl.SubjectValidator;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO dao;
	private Validator validator;

	public SubjectServiceImpl(SubjectDAO dao){
		//this.dao = new SubjectHDAOImpl();
		//this.dao = new SubjectMDAOImpl();
		this.dao = dao;
		this.validator = new SubjectValidator();
	}

	@Override
	public void addSubject(Subject subject) throws IncorectSubjectTitleException{
		if(!validator.vlidate(subject)){
			throw new IncorectSubjectTitleException("Incorect subject title");
		}
		if(dao.getByTitle(subject.getTitle()) != null){
			throw new IncorectSubjectTitleException("Subject with same title already exists");
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
	public void update(Subject subject) throws IncorectSubjectTitleException{
		if(!validator.vlidate(subject)){
			throw new IncorectSubjectTitleException("Incorect subject");
		}
		if(dao.getByTitle(subject.getTitle()) != null){
			throw new IncorectSubjectTitleException("Subject with same title already exists");
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

	@Override
	public List<Subject> getAll() {
		return dao.getAll();
	}

	@Override
	public Subject getById(int id) {
		return dao.getById(id);
	}
}
