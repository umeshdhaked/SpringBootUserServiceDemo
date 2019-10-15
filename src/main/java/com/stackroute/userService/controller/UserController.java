package com.stackroute.userService.controller;


import com.stackroute.userService.domain.User;
import com.stackroute.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;

        if(!userService.ifExist(user.getIdea())) {


            try {
                userService.saveUser(user);
                responseEntity = new ResponseEntity<String>("Successful Created", HttpStatus.CREATED);
            } catch (Exception ex) {
                responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

            }
        }
        else {
            responseEntity = new ResponseEntity<String>("already exist", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User> >(userService.getAllUser(),HttpStatus.OK);
    }

    @DeleteMapping("user")
    public ResponseEntity<?> deleteId(@RequestBody User user){
        userService.deleteId(user.getIdea());
        return new ResponseEntity<List<User> >(userService.getAllUser(),HttpStatus.OK);
    }

    @PutMapping("user")
    public ResponseEntity<?> updateUser(@RequestBody User user){

        return userService.updateUser(user);

    }



}