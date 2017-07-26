package com.exams.dao;

import com.exams.entity.Subject;

/**
 * Created by sanya on 25.07.2017.
 */
public interface SubjectDAO {
	void addSubject(Subject subject);
	Subject getByTitle(String title);
}
