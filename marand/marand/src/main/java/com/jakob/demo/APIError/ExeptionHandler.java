package com.jakob.demo.APIError;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionHandler {
    @ExceptionHandler(Exception.class)
    public  void handleExeption(){

    }
}
