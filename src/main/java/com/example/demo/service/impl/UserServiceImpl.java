package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public User findById(Long id) {
        return userMap.get(id);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return new User(userName, password, 18L);
    }

    @Override
    public User addUser(Long id) {
        User user = new User("test", "123", id);
        userMap.put(id, user);
        return user;
    }

    @Override
    public User updateById(Long id) {
        User user = userMap.get(id);
        user.setName("update name");
        userMap.put(id,user);
        return user;
    }

    @Override
    public String deleteById(Long id) {
        userMap.remove(id);
        return "成功删除id:"+id;
    }




}
