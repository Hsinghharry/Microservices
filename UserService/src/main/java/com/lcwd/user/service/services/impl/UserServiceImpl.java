package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourseNotFoundException;


import com.lcwd.user.service.reposiratory.UserReposiratory;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposiratory userReposiratory;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private HotelServices hotelServices;

    private Logger logger= LoggerFactory.getLogger(UserService.class);



    @Override
    public User saveUser(User user) {
        return userReposiratory.save(user);
    }

    @Override
    public List<User> getUser() {
        return this.userReposiratory.findAll();
    }

    //get by userId
    @Override
    public User getById(long id) {
        User user = userReposiratory.findById(id).orElseThrow(()-> new RuntimeException("Given id is found in server !!"+id));

        // fetching the rating os user from rating service
        Rating[] ratingsofUsers =restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getId(),Rating[].class);

        List<Rating> ratings =Arrays.stream(ratingsofUsers).toList();
        logger.info("{}",ratings);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1

            ResponseEntity<Hotel> forEntity  =restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel=forEntity.getBody();

            //fetching hotelService api by fiegn client.
//            Hotel hotel =hotelServices.getHotel(rating.getHotelId());

            //set the hotel to rate
            rating.setHotel(hotel);
            //rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
