package com.jakob.demo;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "NotFoundExeption not found")
public class NotFoundExeption extends RuntimeException{
    private static final long serialVersionUID=1L;
    public NotFoundExeption(String massage){
        super(massage);
    }
    public NotFoundExeption(String massage, Throwable cause){
        super(massage,cause);
    }
}

