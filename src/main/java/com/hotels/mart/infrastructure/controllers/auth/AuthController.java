package com.hotels.mart.infrastructure.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import com.hotels.mart.application.dto.JWTResponseApiDto;
import com.hotels.mart.application.dto.UserRegisterDto;
import com.hotels.mart.application.services.auth.RegisterUserService;
import com.hotels.mart.infrastructure.config.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

  @Autowired
  RegisterUserService serviceRegister;

  @PostMapping("/login")
  public ResponseEntity<?> loginUser() {

    log.info("Login with JWT");

    JwtUtil jwtUtil = new JwtUtil();
    String token = jwtUtil.generateToken("alexander@nova.com");

    JWTResponseApiDto response = new JWTResponseApiDto();
    response.setMessage("token");
    response.setToken(token);

    return new ResponseEntity<>(response, HttpStatus.CREATED);

  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody UserRegisterDto userRegisterDto) {

    log.info("Register with JWT");

    var response = serviceRegister.createUser(userRegisterDto);

    return new ResponseEntity<>(response, response.getStatus());

  }
}
