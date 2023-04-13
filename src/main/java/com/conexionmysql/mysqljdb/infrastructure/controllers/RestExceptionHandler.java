package com.conexionmysql.mysqljdb.infrastructure.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.conexionmysql.mysqljdb.application.dto.ResponseFormat;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { java.sql.SQLIntegrityConstraintViolationException.class })
    protected ResponseEntity<ResponseFormat> handleIntegrityConstraintViolation(
            java.sql.SQLIntegrityConstraintViolationException ex, WebRequest request) {
        String message = "Error creating reservation: " + ex.getMessage();
        ResponseFormat errorResponse = new ResponseFormat(message, HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

