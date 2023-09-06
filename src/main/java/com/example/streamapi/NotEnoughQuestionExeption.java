package com.example.streamapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionExeption extends RuntimeException{
    public NotEnoughQuestionExeption(String message) {
        super(message);
    }

    public NotEnoughQuestionExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
