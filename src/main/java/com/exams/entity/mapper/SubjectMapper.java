package com.exams.entity.mapper;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sanya on 26.07.2017.
 */
public interface SubjectMapper {
	@Select("SELECT id, title, isenabled FROM subject WHERE id=#{id}")
	Subject selectSubject(int id);

	@Select("SELECT id, title, isenabled FROM subject WHERE title=#{title}")
	Subject getByTitle(String title);

	@Select("SELECT id, title, isenabled FROM subject WHERE id=#{id}")
	Subject getById(int id);

	@Insert("INSERT INTO subject (title, isenabled) VALUES (#{title}, #{isEnabled})")
	@Options(keyProperty = "id")
	void insert(Subject subject);

	@Select("SELECT id, title, isenabled FROM subject ORDER BY title")
	List<Subject> findAllSubject();

	@Select("SELECT id, title, isenabled FROM subject ORDER BY title limit #{param2} offset #{param1}")
	List<Subject> getPerPage(int offset, int limit);

	@Delete("DELETE FROM subject WHERE id=#{id}")
	void delete(Subject subjectMy);

	@Update("UPDATE subject SET title=#{title}, isenabled=#{isEnabled} WHERE id=#{id}")
	void update(Subject subject);

	@Delete("DELETE FROM subject")
	void deleteAll();

	@Select("SELECT COUNT(*) FROM subject")
	Long getCount();

	@Update("UPDATE subject SET isenabled=#{param2} WHERE id=#{param1}")
	void setEnabled(int subjectId, boolean isEnabled);
}
