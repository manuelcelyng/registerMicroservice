package com.minticCicloIV.registerMicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class NotValidValueAdvice {

    @ResponseBody
    @ExceptionHandler(NotValidValueException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String NoValidMoney(NotValidValueException ex){

        return ex.getMessage();

    }
}
