package com.exams.entity.mapper;

import com.exams.entity.Exam;
import com.exams.entity.mapper.provider.ExamMapperProvider;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sanya on 26.07.2017.
 */
public interface ExamMapper {
    @Select("SELECT id, createdate, mark, subject_id FROM exam WHERE id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "mark", property = "mark"),
            @Result(column = "createDate", property = "createDate"),
            @Result(property = "subject", column = "subject_id",
                    one = @One(select = "com.exams.entity.mapper.SubjectMapper.selectSubject"))
    })
    Exam getById(int id);

    @Insert("INSERT INTO exam (createdate, mark, subject_id) VALUES(#{createDate}, #{mark}, #{subject.id})")
    @Options(keyProperty = "id")
    void addExam(Exam exam);


    //@Select("SELECT id, mark, createDate, subject_id FROM exam WHERE subject_id = #{id} ORDER BY createDate ASC")
    @SelectProvider(type= ExamMapperProvider.class, method = "getBySubjectIdSQL")
    List<Exam> getBySubjectId(int id, boolean orderType);

    @Select("SELECT exam.id, mark, createDate, subject_id FROM exam INNER JOIN subject ON exam.subject_id = subject.id  WHERE createDate = #{date} ORDER BY subject.title ASC")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "mark", property = "mark"),
            @Result(column = "createDate", property = "createDate"),
            @Result(property = "subject", column = "subject_id",
                    one = @One(select = "com.exams.entity.mapper.SubjectMapper.selectSubject"))
    })
    List<Exam> getByDate(LocalDate date);

    @Select("SELECT ROUND(AVG(mark), 2) FROM exam WHERE subject_id = #{id}")
    Double getAvgBySubject(int id);

    @Delete("DELETE FROM exam WHERE id=#{id}")
    void delete(Exam exam);

    @Update("UPDATE exam SET createDate = #{createDate}, mark = #{mark}, subject_id = #{subject.id} WHERE id=#{id}")
    void update(Exam exam);
}
