package com.exams.dao;

import com.exams.entity.User;

public interface UserDAO {
    User getById(int id);

    void addUser(User user);

    User getByLoginPassword(User user);
}
