package com.exams.service;

import com.exams.entity.Subject;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public interface SubjectService {
    void addSubject(Subject subject) throws Exception;

    Subject getByTitle(String title);

    void delete(Subject subject);

    void update(Subject subject) throws Exception;

    Long getcount();

    void deleteAll();

    List<Subject> getAll();
}
