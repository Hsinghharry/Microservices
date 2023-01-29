package com.lcwd.ratingService.RatingService.controller;

import com.lcwd.ratingService.RatingService.entities.Rating;
import com.lcwd.ratingService.RatingService.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    //create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));
    }
    //GET ALL
    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        return ResponseEntity.ok(ratingServices.getRating());
    }

    //get Rating by UserId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable long userId){
        return ResponseEntity.ok(ratingServices.getRatingByUserId(userId));
    }

    //get Rating by HotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable long hotelId) {
        return ResponseEntity.ok(ratingServices.getRatingByHotelId(hotelId));
    }


}
