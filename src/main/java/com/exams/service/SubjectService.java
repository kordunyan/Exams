package com.exams.service;

import com.exams.entity.Subject;

/**
 * Created by sanya on 25.07.2017.
 */
public interface SubjectService {
	void addSubject(Subject subject) throws Exception;
	Subject getByTitle(String title);
}
