package com.exams.dao;

import com.exams.entity.Subject;

import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public interface SubjectDAO {
	void addSubject(Subject subject);

	Subject getByTitle(String title);

	void delete(Subject subject);

	void update(Subject subject);

	void deleteAll();

	Long getCount();

	List<Subject> getAll();

	List<Subject> getAllWithExam();

	Subject getById(int id);

	void setEnabled(int subjectId, boolean isEnable);

	List<Subject> getForPage(Integer page, Integer perPage);

	void insertAll(List<Subject> subjects);

}
