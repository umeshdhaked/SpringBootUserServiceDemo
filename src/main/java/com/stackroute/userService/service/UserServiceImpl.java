package com.stackroute.userService.service;

import com.stackroute.userService.domain.User;
import com.stackroute.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //extra
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteId(int id) {

            userRepository.delete(userRepository.getOne(id));
    }


    @Override
    public boolean ifExist(int id) {
        return userRepository.existsById(id);

             }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        if(ifExist(user.getIdea())){
            userRepository.save(user);
        }
        else {
            return new ResponseEntity<String>("First create user then update", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<User> >(getAllUser(),HttpStatus.OK);
    }


}
