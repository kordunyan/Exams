package com.exams.entity.mapper;

import com.exams.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("INSERT INTO users (login, password) VALUES (#{login}, #{password})")
    @Options(keyProperty = "id")
    void addUser(User user);

    @Select("SELECT id, login, password FROM users WHERE login = #{login} AND password = #{password}")
    User getByLoginAndPassword(User user);

    @Select("SELECT id, login, password FROM users WHERE id=#{id}")
    User getById(int id);
}
