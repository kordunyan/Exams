package com.exams.service.impl;

import com.exams.dao.SubjectDAO;
import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;
import com.exams.service.SubjectService;
import com.exams.validator.SubjectValidator;


import java.util.List;


public class SubjectServiceImpl implements SubjectService {

    public static final int PER_PAGE = 7;

    private SubjectDAO dao;
    private SubjectValidator validator;

    public SubjectServiceImpl(SubjectDAO dao) {
        this.dao = dao;
        this.validator = new SubjectValidator();
    }

    @Override
    public void addSubject(Subject subject) throws IncorectSubjectTitleException {
        //log.info("Add subject: " + subject);
        validator.vlidate(subject);
        if (dao.getByTitle(subject.getTitle()) != null) {
            throw new IncorectSubjectTitleException("Subject with same title already exists");
        }
        try {
            dao.addSubject(subject);
        } catch (Exception ex) {
            //log.error("Error to add subject " + subject, ex);
            throw ex;
        }
    }

    @Override
    public Subject getByTitle(String title) {
        //log.info("Get subject by title: " + title);
        try {
            return dao.getByTitle(title);
        } catch (Exception ex) {
            //log.error("Error get subject  by title: " + title, ex);
            throw ex;
        }
    }

    @Override
    public void delete(Subject subject) {
        //log.info("Delete subject: " + subject);
        try {
            dao.delete(subject);
        } catch (Exception ex) {
            //log.error("Error Delete subject: " + subject, ex);
            throw ex;
        }
    }

    @Override
    public void update(Subject subject) throws IncorectSubjectTitleException {
        //log.info("Update subject: " + subject);
        validator.vlidate(subject);
        if (dao.getByTitle(subject.getTitle()) != null) {
            throw new IncorectSubjectTitleException("Subject with same title already exists");
        }
        try {
            dao.update(subject);
        } catch (Exception ex) {
            //log.error("Error to Update subject " + subject, ex);
            throw ex;
        }
    }

    @Override
    public Long getcount() {
        //log.info("Get count");
        try {
            return dao.getCount();
        } catch (Exception ex) {
            //log.error("Error get count", ex);
            throw ex;
        }
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<Subject> getAll() {
        //log.info("Get all subjects");
        try {
            return dao.getAll();
        } catch (Exception ex) {
            //log.error("Error to get all subject", ex);
            throw ex;
        }
    }

    @Override
    public List<Subject> getAllWithExams() {
        //log.info("Get all with exams");
        try{
            return dao.getAllWithExam();
        }
        catch(Exception ex){
            //log.error("Error to get all subject with exams", ex);
            throw ex;
        }
    }

    @Override
    public List<Subject> getFormPage(int page, int perPage) {
        //log.info("Get subjects for page: " + page + ", per page: " + perPage);
        try{
            return dao.getForPage(page, perPage);
        }
        catch(Exception ex){
            //log.error("Error to get subjects for page: " + page + ", per page: " + perPage, ex);
            throw ex;
        }
    }

    @Override
    public Subject getById(int id) {
        //log.info("Get subject by id: " + id);
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            //log.error("Error get subject  by id: " + id, ex);
            throw ex;
        }
    }

    @Override
    public void setEnabled(int subjectId, boolean isEnabled) {
        //log.info("Set enabled subject id: " + subjectId + ", isEnabled: " + isEnabled);
        try {
            dao.setEnabled(subjectId, isEnabled);
        } catch (Exception ex) {
            //log.error("Error to set enabled subject id: " + subjectId + ", isEnabled: " + isEnabled, ex);
            throw ex;
        }
    }

    public int calculateCountPages(long countItems, int perPage){
        return (int) Math.ceil((double) countItems / perPage);
    }

    @Override
    public void insertAll(List<Subject> subjects) {
        //log.info("Insert all subject");
        try{
            dao.insertAll(subjects);
        }
        catch (Exception ex){
            //log.error("Error to insert all: ", ex);
            throw ex;
        }
    }
}
