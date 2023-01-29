package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourseNotFoundException;
import com.lcwd.user.service.reposiratory.UserReposiratory;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserReposiratory userReposiratory;

    @Override
    public User saveUser(User user) {
        return userReposiratory.save(user);
    }

    @Override
    public List<User> getUser() {
        return this.userReposiratory.findAll();
    }

    @Override
    public User getById(long id) {
        return userReposiratory.findById(id).orElseThrow(()-> new RuntimeException("Given id is found in server !!"+id));
    }
}
