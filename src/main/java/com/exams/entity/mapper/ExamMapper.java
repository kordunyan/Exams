package com.exams.entity.mapper;

import com.exams.entity.Exam;
import com.exams.entity.Subject;
import com.exams.entity.mapper.provider.ExamMapperProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

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


    @SelectProvider(type= ExamMapperProvider.class, method = "getBySubjectIdSQL")
    List<Exam> getBySubjectId(int id, boolean orderType);

    @SelectProvider(type= ExamMapperProvider.class, method = "getBySubjectIdForPageSQL")
    List<Exam> getBySubjectIdForPage(int id, boolean orderType, RowBounds rowBounds);

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

    @Select("SELECT id, mark, createDate, subject_id FROM exam  WHERE subject_id = #{subject_id}")
    List<Exam> getBySubject(int subject_id);

    @Delete("DELETE FROM exam WHERE id=#{id}")
    void delete(Exam exam);

    @Update("UPDATE exam SET createDate = #{createDate}, mark = #{mark}, subject_id = #{subject.id} WHERE id=#{id}")
    void update(Exam exam);

    @Select("SELECT id, mark, createDate, subject_id FROM exam  WHERE subject_id = #{param1.id} AND createDate = #{param2}")
    Exam getBySubjectAndDate(Subject subject, LocalDate date);

    @Select("SELECT COUNT(*) FROM exam")
    Long getCount();

    @Delete("DELETE FROM exam")
    void deleteAll();

    @Select("SELECT COUNT(*) FROM exam WHERE subject_id = #{subjectId}")
    Long getCountBySubjectId(int subjectId);

    @Insert({"<script>",
            "INSERT INTO  exam (createdate, mark, subject_id) values ",
            "<foreach collection='exams' item='ex' separator = '),(' open ='(' close=')' >#{ex.createDate}, #{ex.mark}, #{param2}</foreach>",
            "</script>"})
    void insertAll(@Param("exams") List<Exam> exams, int subject_id);
}
