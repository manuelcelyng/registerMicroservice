package com.minticCicloIV.registerMicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class NotFoundCustomerAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundCustomerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NoValidEmail(NotFoundCustomerException ex){

        return ex.getMessage();

    }
}
