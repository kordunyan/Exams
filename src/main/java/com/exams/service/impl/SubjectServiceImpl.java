package com.exams.service.impl;

import com.exams.dao.SubjectDAO;
import com.exams.dao.hibernateImpl.SubjectHDAOImpl;
import com.exams.dao.mybatisImpl.SubjectMDAOImpl;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.SubjectService;
import com.exams.validator.Validator;
import com.exams.validator.impl.SubjectValidator;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class SubjectServiceImpl implements SubjectService {

	private SubjectDAO dao;
	private Validator validator;

	public SubjectServiceImpl(){
		//this.dao = new SubjectHDAOImpl();
		this.dao = new SubjectMDAOImpl();
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
		try{
			log.info("Add subject: " + subject);
			dao.addSubject(subject);
		}
		catch(Exception ex){
			log.error("Error to add subject " + subject, ex);
		}
	}

	@Override
	public Subject getByTitle(String title) {
		try{
			log.info("Get subject by title: " + title);
			return dao.getByTitle(title);
		}
		catch(Exception ex){
			log.error("Error get subject  by title: " + title, ex);
		}
		return null;
	}

	@Override
	public void delete(Subject subject) {
		try{
			log.info("Delete subject: " + subject);
			dao.delete(subject);
		}
		catch(Exception ex){
			log.error("Error Delete subject: " + subject, ex);
		}
	}

	@Override
	public void update(Subject subject) throws IncorectSubjectTitleException{
		if(!validator.vlidate(subject)){
			throw new IncorectSubjectTitleException("Incorect subject");
		}
		if(dao.getByTitle(subject.getTitle()) != null){
			throw new IncorectSubjectTitleException("Subject with same title already exists");
		}
		try{
			log.info("Update subject: " + subject);
			dao.update(subject);
		}
		catch(Exception ex){
			log.error("Error to Update subject " + subject, ex);
		}
	}

	@Override
	public Long getcount() {
		try{
			log.info("Get count");
			return dao.getCount();
		}
		catch(Exception ex){
			log.error("Error get count", ex);
		}
		return null;
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<Subject> getAll() {
		try{
			log.info("Get all subjects");
			return dao.getAll();
		}
		catch (Exception ex){
			log.error("Error to get all subject", ex);
		}
		return null;
	}

	@Override
	public Subject getById(int id) {
		try{
			log.info("Get subject by id: " + id);
			return dao.getById(id);
		}
		catch(Exception ex){
			log.error("Error get subject  by id: " + id, ex);
		}
		return null;
	}
}
