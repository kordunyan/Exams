package com.exams.service;

import com.exams.entity.Exam;

import java.time.LocalDate;
import java.util.List;


public interface ExamService {
	void addExam(Exam exam) throws Exception;

	Exam getById(Integer id);

	List<Exam> getBySubjectId(Integer subjectId);

	List<Exam> getByCreateDate(LocalDate createDate);

	Double getAvgBySubjectId(Integer subjectId);

	void delete(Exam exam);

	void update(Exam exam) throws Exception;
}
