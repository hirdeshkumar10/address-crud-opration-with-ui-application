package com.sunglowsys.web.util;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
