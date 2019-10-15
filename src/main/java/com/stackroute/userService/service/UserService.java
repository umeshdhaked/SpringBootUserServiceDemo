package com.stackroute.userService.service;

import com.stackroute.userService.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public void deleteId(int id);
    public boolean ifExist(int id);
    public ResponseEntity<?> updateUser(User user);

}
