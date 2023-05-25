package com.hotels.mart.infrastructure.controllers.auth;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.ResponseFormat;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

  @PostMapping("/login")
  public ResponseEntity<?> sendEmail() {

    log.info("Login with JWT");
    

    ResponseFormat responseFormat = new ResponseFormat(
        "Login Succefullly",
        HttpStatus.ACCEPTED.value(),
        LocalDateTime.now());

    return new ResponseEntity<>(responseFormat, HttpStatus.CREATED);

  }
}
