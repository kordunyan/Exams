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
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.util.List;

@Log4j
public class ExamServiceImpl implements ExamService {

	private ExamDAO dao;
	private Validator validator;

	public ExamServiceImpl(){
		//this.dao = new ExamHDAOImpl();
		this.dao = new ExamMDAOImpl();
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
		try{
			log.info("Add exam : " + exam);
			dao.addExam(exam);
		}
		catch (Exception ex){
			log.error(" Error to add exam : " + exam, ex);
		}
	}

	@Override
	public Exam getById(Integer id) {
		try{
			log.info("Get exam by id: " + id);
			return dao.getExamById(id);
		}
		catch(Exception ex){
			log.error("Error to get exam by id: " + id, ex);
		}
		return null;
	}

	@Override
	public List<Exam> getBySubjectId(Integer subjectId, boolean orderType) {
		try{
			log.info("Get exam by subject id: " + subjectId + ", order: " + orderType);
			return dao.getBySubjectId(subjectId, orderType);
		}
		catch(Exception ex){
			log.error("Error to get exam by subject id: " + subjectId + ", order: " + orderType, ex);
		}
		return null;
	}

	@Override
	public List<Exam> getByCreateDate(LocalDate createDate) {
		try{
			log.info("Get exam by create date: " + createDate);
			return dao.getByCreateDate(createDate);
		}
		catch(Exception ex){
			log.error("Error to get exam by create date: " + createDate, ex);
		}
		return null;
	}

	@Override
	public Double getAvgBySubjectId(Integer subjectId) {
		try{
			log.info("Get avg by subkect id: " + subjectId);
			return dao.getAvgBySubjectId(subjectId);
		}
		catch(Exception ex){
			log.error("Error to get avg by subkect id: " + subjectId, ex);
		}
		return null;
	}

	@Override
	public void delete(Exam exam) {
		try{
			log.info("Delete exam: " + exam);
			dao.delete(exam);
		}
		catch(Exception ex){
			log.error("Error to delete exam: " + exam, ex);
		}
	}

	@Override
	public Exam getBySubjectAndDate(Subject subject, LocalDate date) {
		try{
			log.info("Get by subject: " + subject + ", date: " + date);
			return dao.getBySubjectAndDate(subject, date);
		}
		catch(Exception ex){
			log.error("Error to get by subject: " + subject + ", date: " + date, ex);
		}
		return null;
	}

	@Override
	public Long getCount() {
		try{
			log.info("Get count");
			return dao.getCount();
		}
		catch(Exception ex){
			log.error("Error to get count", ex);
		}
		return null;
	}

	@Override
	public void deleteAll() {
		try{
			log.info("Delete all");
			dao.deleteAll();
		}
		catch(Exception ex){
			log.error("Error to delete all", ex);
		}
	}

	@Override
	public void update(Exam exam) throws IncorectDateException, ExamExistsException {
		if(!validator.vlidate(exam.getCreateDate())){
			throw new IncorectDateException("Incorect date");
		}
		if(dao.getBySubjectAndDate(exam.getSubject(), exam.getCreateDate()) != null){
			throw new ExamExistsException("Such exam exists on this date");
		}
		try{
			log.info("Update exam : " + exam);
			dao.update(exam);
		}
		catch (Exception ex){
			log.error("Error to update exam : " + exam, ex);
		}
	}



}
