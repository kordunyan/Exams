package com.exams.entity.mapper.provider;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class ExamMapperProvider {

    public String getBySubjectIdSQL(Map<String, Object> map) {
        Boolean orderType = (Boolean) map.get("param2");
        return new SQL() {
            {
                SELECT("id, mark, createDate, subject_id");
                FROM("exam");
                WHERE("subject_id=#{param1}");
                ORDER_BY("createDate " + ((orderType)? "ASC":"DESC"));
            }
        }.toString();
    }

    public String getBySubjectIdForPageSQL(Map<String, Object> map){
        Boolean orderType = (Boolean) map.get("param2");
        return new SQL() {
            {
                SELECT("id, mark, createDate, subject_id");
                FROM("exam");
                WHERE("subject_id=#{param1}");
                ORDER_BY("createDate " + ((orderType)? "ASC":"DESC"));
            }
        }.toString();
    }

}
