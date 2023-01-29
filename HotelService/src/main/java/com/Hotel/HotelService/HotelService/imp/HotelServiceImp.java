package com.Hotel.HotelService.HotelService.imp;

import com.Hotel.HotelService.HotelService.HotelService;
import com.Hotel.HotelService.entities.Hotel;
import com.Hotel.HotelService.exceptions.ResourceNotFoundException;
import com.Hotel.HotelService.reposiratory.HotelReposiratory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    public HotelReposiratory hotelReposiratory;


    @Override
    public Hotel create(Hotel hotel) {
        return hotelReposiratory.save(hotel);
    }

    @Override
    public List<Hotel> getall() {
        return hotelReposiratory.findAll();
    }

    @Override
    public Hotel getbyid(Long id) {



        return hotelReposiratory.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id is not found in server !!"));
    }
}
