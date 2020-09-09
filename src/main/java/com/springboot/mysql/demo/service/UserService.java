package com.springboot.mysql.demo.service;


import com.springboot.mysql.demo.model.User;
import com.springboot.mysql.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> findAllUsers() {
       return (List<User>) repository.findAll();
    }

    @Override
    public String createUser(String Name, String Sex,long Contact_Number,int Age) {
       User u = new User();
       u.setAGE(Age);
       u.setCONTACT_NUMBER(Contact_Number);
       u.setNAME(Name);
       u.setSEX(Sex);
       this.repository.save(u);
       return "user created!";
    }

    @Override
    public String deleteUser(long id) {
        this.repository.deleteById(id);
        return "deleted";
    }

}
