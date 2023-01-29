package com.lcwd.ratingService.RatingService.services;

import com.lcwd.ratingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingServices {

    //create
    Rating create(Rating rating);

    //get all rating
    List<Rating> getRating();

    //get all by userid
    List<Rating> getRatingByUserId(long userid);

    //get all by hotelId
    List<Rating> getRatingByHotelId(long hotelId);
}
