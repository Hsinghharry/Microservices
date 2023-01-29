package com.Hotel.HotelService.HotelService;

import com.Hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    // create
    Hotel create(Hotel hotel);

    //get
    List<Hotel> getall();

    //get by id
    Hotel getbyid(Long id);

}
