package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;


public interface UserService {

    //create
    User saveUser(User user);

    //get all user
    List<User> getUser();

    //get single user of givenID
    User getById(long id);
}
