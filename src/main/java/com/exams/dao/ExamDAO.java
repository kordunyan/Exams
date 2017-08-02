package com.exams.dao;

import com.exams.entity.Exam;
import com.exams.entity.Subject;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sanya on 25.07.2017.
 */
public interface ExamDAO {

	void addExam(Exam exam);

	Exam getExamById(Integer id);

	List<Exam> getBySubjectId(Integer subjectId, boolean orderType);

	List<Exam> getBySubjectIdForPage(Integer page, Integer perPage, Integer subjectId, boolean orderType);

	List<Exam> getByCreateDate(LocalDate createDate);

	Double getAvgBySubjectId(Integer subjectId);

	void delete(Exam exam);

	void update(Exam exam);

	Exam getBySubjectAndDate(Subject subject, LocalDate date);

	Long getCount();

	Long getCountBySubject(int subjectId);

	void deleteAll();
}
