package com.exams.service.impl;

import com.exams.dao.UserDAO;
import com.exams.entity.User;
import com.exams.service.UserService;


public class UserServiceImpl implements UserService {

    //private static Logger log = Logger.getLogger("file");

    private UserDAO dao;

    public UserServiceImpl(UserDAO dao){
        this.dao = dao;
    }

    @Override
    public void addUser(User user) {
        //log.info("Add user: " + user);
        try{
            dao.addUser(user);
        }
        catch (Exception ex){
            //log.error(" Error to add user : " + user, ex);
            throw ex;
        }
    }

    @Override
    public User getById(int id) {
        //log.info("Get user by id: " + id);
        try{
            return dao.getById(id);
        }
        catch(Exception ex){
            //log.error("Error to get user by id: " + id, ex);
            throw ex;
        }
    }

    @Override
    public User getByLoginAndPassword(User user) {
        //log.info("Get user by login: " + user.getLogin() + ", password: " + user.getPassword());
        try{
            return dao.getByLoginPassword(user);
        }
        catch (Exception ex){
            //log.info("Error to get user by login: " + user.getLogin() + ", password: " + user.getPassword(), ex);
            throw ex;
        }
    }

    @Override
    public boolean isExists(User user) {
        //log.info("Check is exists user: " + user);
        try{
            return dao.getByLoginPassword(user) != null;
        }
        catch (Exception ex){
            //log.info("Error to check is exists user: " + user);
            throw  ex;
        }
    }
}
