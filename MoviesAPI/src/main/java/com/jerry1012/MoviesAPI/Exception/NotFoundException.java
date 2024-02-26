package com.jerry1012.MoviesAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException() {}

    public NotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
