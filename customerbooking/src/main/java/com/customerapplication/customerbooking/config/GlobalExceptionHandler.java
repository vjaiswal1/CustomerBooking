package com.customerapplication.customerbooking.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customerapplication.customerbooking.utility.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions( Exception exception, WebRequest webRequest) {
        ErrorResponse response = new ErrorResponse();
        response.setDateTime(LocalDateTime.now());
        response.setErrorMessage(exception.getLocalizedMessage());
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
