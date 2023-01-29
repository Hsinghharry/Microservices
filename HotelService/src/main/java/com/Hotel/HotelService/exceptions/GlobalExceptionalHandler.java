package com.Hotel.HotelService.exceptions;

import com.Hotel.HotelService.entities.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    public ResponseEntity<Map<String, Objects>> notFoundHandler(ResourceNotFoundException ex){
        Map map= new HashMap();
        map.put("message",ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

}
