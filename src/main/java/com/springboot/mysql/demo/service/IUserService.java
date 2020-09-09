package com.springboot.mysql.demo.service;

import com.springboot.mysql.demo.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findAllUsers();
    public String createUser(String Name, String Sex,long Contact_Number,int Age);
    public String deleteUser(long id);
}
