package com.Hotel.HotelService.controller;

import com.Hotel.HotelService.HotelService.HotelService;
import com.Hotel.HotelService.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // crete hotel
    @PostMapping
    public ResponseEntity<Hotel> createhotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }
    // GETALL HOTEL
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getall());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getbyid(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getbyid(id));
    }
}
