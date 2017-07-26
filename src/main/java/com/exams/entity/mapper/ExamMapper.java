package com.exams.entity.mapper;

import com.exams.entity.Exam;
import org.apache.ibatis.annotations.Select;

/**
 * Created by sanya on 26.07.2017.
 */
public interface ExamMapper {
	@Select("SELECT id, createdate as createDate, mark FROM exam WHERE id=#{id}")
	Exam getById(int id);
}
