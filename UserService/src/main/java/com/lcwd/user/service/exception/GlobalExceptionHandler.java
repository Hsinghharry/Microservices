package com.lcwd.user.service.exception;

import com.lcwd.user.service.payload.ApiResponse;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourseNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new  ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND );

    }
}