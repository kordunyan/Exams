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

    public SubjectServiceImpl(SubjectDAO dao) {
        this.dao = dao;
        this.validator = new SubjectValidator();
    }

    @Override
    public void addSubject(Subject subject) throws IncorectSubjectTitleException {
        log.info("Add subject: " + subject);
        if (!validator.vlidate(subject)) {
            throw new IncorectSubjectTitleException("Incorect subject title");
        }
        if (dao.getByTitle(subject.getTitle()) != null) {
            throw new IncorectSubjectTitleException("Subject with same title already exists");
        }
        try {
            subject.setIsEnabled(true);
            dao.addSubject(subject);
        } catch (Exception ex) {
            log.error("Error to add subject " + subject, ex);
            throw ex;
        }
    }

    @Override
    public Subject getByTitle(String title) {
        log.info("Get subject by title: " + title);
        try {
            return dao.getByTitle(title);
        } catch (Exception ex) {
            log.error("Error get subject  by title: " + title, ex);
            throw ex;
        }
    }

    @Override
    public void delete(Subject subject) {
        log.info("Delete subject: " + subject);
        try {
            dao.delete(subject);
        } catch (Exception ex) {
            log.error("Error Delete subject: " + subject, ex);
            throw ex;
        }
    }

    @Override
    public void update(Subject subject) throws IncorectSubjectTitleException {
        log.info("Update subject: " + subject);
        if (!validator.vlidate(subject)) {
            throw new IncorectSubjectTitleException("Incorect subject");
        }
        if (dao.getByTitle(subject.getTitle()) != null) {
            throw new IncorectSubjectTitleException("Subject with same title already exists");
        }
        try {
            dao.update(subject);
        } catch (Exception ex) {
            log.error("Error to Update subject " + subject, ex);
            throw ex;
        }
    }

    @Override
    public Long getcount() {
        log.info("Get count");
        try {
            return dao.getCount();
        } catch (Exception ex) {
            log.error("Error get count", ex);
            throw ex;
        }
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public List<Subject> getAll() {
        log.info("Get all subjects");
        try {
            return dao.getAll();
        } catch (Exception ex) {
            log.error("Error to get all subject", ex);
            throw ex;
        }
    }

    @Override
    public Subject getById(int id) {
        log.info("Get subject by id: " + id);
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            log.error("Error get subject  by id: " + id, ex);
            throw ex;
        }
    }

    @Override
    public void setEnabled(int subjectId, boolean isEnabled) {
        log.info("Set enabled subject id: " + subjectId + ", isEnabled: " + isEnabled);
        try {
            dao.setEnabled(subjectId, isEnabled);
        } catch (Exception ex) {
            log.error("Error to set enabled subject id: " + subjectId + ", isEnabled: " + isEnabled, ex);
            throw ex;
        }
    }
}
