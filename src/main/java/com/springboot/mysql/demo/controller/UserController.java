package com.springboot.mysql.demo.controller;


import com.springboot.mysql.demo.service.IUserService;
import com.springboot.mysql.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    IUserService userService;

    @GetMapping("/all/users")
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.ok().body(userService.findAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not found");
    }

    @PostMapping("/user/{Name}/{Age}/{Sex}/{Num}")
    public ResponseEntity<?> createUser(
            @PathVariable String Name,
            @PathVariable int Age,
            @PathVariable String Sex,
            @PathVariable Long Num
            ){
        try {
            return ResponseEntity.ok().body(userService.createUser(Name,Sex,Num,Age));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not created");
    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        try {
            return ResponseEntity.ok().body(userService.deleteUser(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not found");
    }
}
