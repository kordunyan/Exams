package com.exams.service;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.exception.ExamExistsException;
import com.exams.exception.IncorectDateException;
import com.exams.exception.IncorectMarkException;
import com.exams.exception.IncorectSubjectTitleException;

import java.time.LocalDate;
import java.util.List;


public interface ExamService {
	void addExam(Exam exam) throws IncorectDateException, ExamExistsException, IncorectSubjectTitleException, IncorectMarkException;

	void update(Exam exam) throws IncorectDateException, ExamExistsException;

	Exam getById(Integer id);

	List<Exam> getBySubjectId(Integer subjectId, boolean orderType);

	List<Exam> getByCreateDate(LocalDate createDate);

	Double getAvgBySubjectId(Integer subjectId);

	void delete(Exam exam);

	Exam getBySubjectAndDate(Subject subject, LocalDate date);

	Long getCount();

	Long getCountBySubject(int subjectId);

	List<Exam> getExamsForPage(Integer page, Integer perPage, Integer subjectId, boolean orderType);

	void deleteAll();

	int calculateCountPages(long countItems, int perPage);
}
