package com.lcwd.ratingService.RatingService.services.impl;

import com.lcwd.ratingService.RatingService.Reposiratory.RatingReposiratory;
import com.lcwd.ratingService.RatingService.entities.Rating;
import com.lcwd.ratingService.RatingService.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingServices {

    @Autowired
    private RatingReposiratory ratingReposiratory;

    @Override
    public Rating create(Rating rating) {
        return ratingReposiratory.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingReposiratory.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(long userId) {
        return ratingReposiratory.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(long hotelId) {
        return ratingReposiratory.findByHotelId(hotelId);
    }
}
