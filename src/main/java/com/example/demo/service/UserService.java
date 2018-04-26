package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {


    User findById(Long id);

    User findByUserNameAndPassword(String userName,String password);

    User addUser(Long id);


    User updateById(Long id);

    String deleteById(Long id);
}
