package com.exams.entity.mapper;

import com.exams.entity.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by sanya on 26.07.2017.
 */
public interface SubjectMapper {
	@Select("SELECT id, title FROM subject WHERE id=#{id}")
	Subject selectSubject(int id);

	@Insert("INSERT INTO subject (title) VALUES (#{title})")
	@Options(keyProperty = "id")
	void insert(Subject subject);

	@Select("SELECT id, title FROM subject")
	List<Subject> findAllSubject();
}
