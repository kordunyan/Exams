package com.exams.entity.mapper;

import com.exams.entity.Exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sanya on 26.07.2017.
 */
public interface ExamMapper {
	@Select("SELECT id, createdate, mark FROM exam WHERE id=#{id}")
	Exam getById(int id);

	@Insert("INSERT INTO exam (createdate, mark, subject_id) VALUES(#{createDate}, #{mark}, #{subject.id})")
	@Options(keyProperty = "id")
	void addExam(Exam exam);
}
