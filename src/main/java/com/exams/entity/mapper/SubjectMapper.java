package com.exams.entity.mapper;

import com.exams.entity.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sanya on 26.07.2017.
 */
public interface SubjectMapper {
	@Select("SELECT id, title FROM subject WHERE id=#{id}")
	Subject selectSubject(int id);

	@Select("SELECT id, title FROM subject WHERE title=#{title}")
	Subject getByTitle(String title);

	@Insert("INSERT INTO subject (title) VALUES (#{title})")
	@Options(keyProperty = "id")
	void insert(Subject subject);

	@Select("SELECT id, title FROM subject")
	List<Subject> findAllSubject();

	@Delete("DELETE FROM subject WHERE id=#{id}")
	void delete(Subject subjectMy);

	@Update("UPDATE subject SET title=#{title} WHERE id=#{id}")
	void update(Subject subject);

	@Delete("DELETE FROM subject")
	void deleteAll();

	@Select("SELECT COUNT(*) FROM subject")
	Long getCount();
}
