package com.lcwd.user.service.exception;

public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(){
        super("Resource Not Found in Server !!");
    }

    public ResourseNotFoundException(String message){
        super(message);

    }
}
