package com.exams.service;

import com.exams.entity.User;

public interface UserService {
    void addUser(User user);
    User getById(int id);
    User getByLoginAndPassword(User user);
    boolean isExists(User user);
}
