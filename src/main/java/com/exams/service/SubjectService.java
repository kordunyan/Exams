package com.exams.service;

import com.exams.entity.Subject;
import com.exams.exception.IncorectSubjectTitleException;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public interface SubjectService {
    void addSubject(Subject subject) throws IncorectSubjectTitleException;

    Subject getByTitle(String title);

    void delete(Subject subject);

    void update(Subject subject) throws IncorectSubjectTitleException;

    Long getcount();

    void deleteAll();

    List<Subject> getAll();

    Subject getById(int id);

    void setEnabled(int subjectId, boolean isEnabled);
}
